package by.ihorosho.services.utils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DtoConverter<FROM, TO> {
    private static final String GET_STR = "get";
    private static final String SET_STR = "set";

    private String[] fieldNames;

    public DtoConverter(String... fieldNames) {
        this.fieldNames = fieldNames;
    }

    public DtoConverter<TO, FROM> getReverseConverter() {
        return new DtoConverter<TO, FROM>(fieldNames);
    }

    public TO convert(FROM fromObject, TO toObject) {
        Class<?> fromClass = fromObject.getClass();
        Class<?> toClass = toObject.getClass();
        for (String fieldName : fieldNames) {
            try {
                Method getter = fromClass.getDeclaredMethod(GET_STR + fieldName);
                Method setter = toClass.getDeclaredMethod(SET_STR + fieldName, getter.getReturnType());

                getter.setAccessible(true);
                Object value = getter.invoke(fromObject);
                if (value == null) {
                    continue;
                }

                setter.setAccessible(true);
                setter.invoke(toObject, value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return toObject;
    }

    public TO convert(FROM fromObject, Class<? extends TO> toClass) {
        try {
            Class<?> fromClass = fromObject.getClass();
            TO toObject = toClass.newInstance();
            for (String fieldName : fieldNames) {
                try {
                    Method getter = fromClass.getDeclaredMethod(GET_STR + fieldName);
                    Method setter = toClass.getDeclaredMethod(SET_STR + fieldName, getter.getReturnType());

                    getter.setAccessible(true);
                    Object value = getter.invoke(fromObject);

                    setter.setAccessible(true);
                    setter.invoke(toObject, value);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return toObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TO> convert(List<FROM> fromList, Class<? extends TO> toClass) {
        return fromList.stream().map(e -> {
            try {
                return convert(e, toClass.newInstance());
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    public List<TO> convert(Set<FROM> fromList, Class<? extends TO> toClass) {
        return fromList.stream().map(e -> {
            try {
                return convert(e, toClass.newInstance());
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }
}
