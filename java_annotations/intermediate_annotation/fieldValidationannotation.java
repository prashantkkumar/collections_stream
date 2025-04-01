package java_annotations.intermediate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Step 2: Apply Annotation to Fields
class User {

    @MaxLength(10)
    private String username;

    @MaxLength(5)
    private String code;

    public User(String username, String code) {
        this.username = username;
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public String getCode() {
        return code;
    }
}

public class fieldValidationannotation {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                String fieldValue = (String) field.get(obj);

                if (fieldValue.length() > annotation.value()) {
                    System.out.println("Error: " + field.getName() + " exceeds max length of " + annotation.value());
                } else {
                    System.out.println(field.getName() + " is valid.");
                }
            }
        }
    }
    public static void main(String[] args) throws IllegalAccessException {
        User user1 = new User("Alice12345", "A1");  // Valid
        User user2 = new User("SuperLongUsername", "ABCDE"); // Invalid username
        User user3 = new User("Bob", "XYZ123"); // Invalid code

        System.out.println("Validating user1:");
        validate(user1);

        System.out.println("\nValidating user2:");
        validate(user2);

        System.out.println("\nValidating user3:");
        validate(user3);
    }
}
