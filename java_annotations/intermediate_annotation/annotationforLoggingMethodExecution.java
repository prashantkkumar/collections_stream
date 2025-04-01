package java_annotations.intermediate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

public class annotationforLoggingMethodExecution {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Demo dc = new Demo();

        Class<?> sc = Demo.class;
        for (Method method : sc.getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecutionTime.class)){
                double st = System.currentTimeMillis();

                method.invoke(dc);

                double tf = System.currentTimeMillis();
                System.out.println("Execution time of " + method.getName() + ": " + (tf -st) + " ms\n");
            }
        }
    }

    public static class Demo {
        Demo(){};

        @LogExecutionTime
        void firstMethd(){
            System.out.println("printing first method");

            try{
                Thread.sleep(5000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @LogExecutionTime
        void SecondMethod(){
            System.out.println("we are printing second method :  ");

            for(int i = 0; i < 1000; i++){

            }
        }
    }
}
