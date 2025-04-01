package java_annotations.basic_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}


class MyService {

    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod
    public void generateReport() {
        System.out.println("Generating report...");
    }

    @ImportantMethod
    public void normalMethod() {
        System.out.println("This is a normal method.");
    }
}


public class importantMethods {
    public static void main(String[] args) {

        Class<MyService> obj = MyService.class;


        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);


                System.out.println("Method = " + method.getName() + " | Level = " + annotation.level());
            }
        }
    }
}
