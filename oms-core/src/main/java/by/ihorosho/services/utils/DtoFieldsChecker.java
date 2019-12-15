package by.ihorosho.services.utils;

import java.lang.reflect.Field;
import java.util.Collection;

public class DtoFieldsChecker<T> {
    private String[] fields;

    public DtoFieldsChecker(String... fields) {
        this.fields = fields;
    }

    public void isNullOrEmpty(T dto) {
        Class<?> clazz = dto.getClass();
        for (String fieldName : fields) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(dto);

                if (value == null || (value instanceof Collection && ((Collection) value).isEmpty())) {
                    throw new IllegalArgumentException(fieldName + " is Null or Empty");
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
