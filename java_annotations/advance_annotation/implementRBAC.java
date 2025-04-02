package java_annotations.advance_annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}


class User {
    private final String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


class AccessController {
    public static void invokeMethod(Object obj, String methodName, User user) throws Exception{

            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!user.getRole().equals(requiredRole)) {
                    System.out.println("Access Denied!");
                    return;
                }
            }
            method.invoke(obj);
    }
}


class DemoService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }

    public void publicTask() {
        System.out.println("Public task executed!");
    }
}


public class implementRBAC {
    public static void main(String[] args) throws Exception {
        DemoService service = new DemoService();

        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        System.out.println("Trying with ADMIN:");
        AccessController.invokeMethod(service, "adminTask", adminUser);

        System.out.println("\nTrying with USER:");
        AccessController.invokeMethod(service, "adminTask", normalUser);
    }
}

