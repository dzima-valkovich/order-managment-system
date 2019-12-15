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

    public TO convert(FROM fromObject, TO toObject) {
        Class<?> fromClass = fromObject.getClass();
        Class<?> toClass = toObject.getClass();
        for (String fieldName : fieldNames) {
            try {
                Method getter = fromClass.getDeclaredMethod(GET_STR + fieldName);
                if (getter == null) {
                    continue;
                }
                Method setter = toClass.getDeclaredMethod(SET_STR + fieldName, getter.getReturnType());
                if (setter == null) {
                    continue;
                }

                getter.setAccessible(true);
                Object value = getter.invoke(fromObject);

                setter.setAccessible(true);
                setter.invoke(toObject, value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return toObject;
    }

    public List<TO> convert(List<FROM> fromList, Class<TO> toClass) {
        return fromList.stream().map(e -> {
            try {
                return convert(e, toClass.newInstance());
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

    public List<TO> convert(Set<FROM> fromList, Class<TO> toClass) {
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
