package java_annotations.advance_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}


class UserNN {
    @JsonField(name = "User_name")
    private String name;

    @JsonField(name = "User_age")
    private int age;

    public UserNN(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class JsonSerializer {
    public static String serialize(Object obj) throws Exception {

            Map<String, String> jsonMap = new HashMap<>();
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(JsonField.class)) {
                    String jsonKey = field.getAnnotation(JsonField.class).name();
                    Object value = field.get(obj);
                    jsonMap.put(jsonKey, value.toString());
                }
            }
            return jsonMap.toString().replace("=", ":").replace("{", "{").replace("}", "}");
    }
}


public class implementCustonSerializationAnn {
    public static void main(String[] args) throws Exception {
        UserNN user = new UserNN("Prashant", 25);
        String jsonString = JsonSerializer.serialize(user);
        System.out.println(jsonString);
    }
}

