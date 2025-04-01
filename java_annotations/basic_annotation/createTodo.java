package java_annotations.basic_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}


class Project {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login functionality.");
    }

    @Todo(task = "Improve database performance", assignedTo = "Bob") // Default priority: MEDIUM
    public void optimizeDatabase() {
        System.out.println("Database optimization.");
    }

    @Todo(task = "Fix UI responsiveness issue", assignedTo = "Charlie", priority = "CRITICAL")
    public void fixUI() {
        System.out.println("Fixing UI responsiveness.");
    }

    public void completedFeature() {
        System.out.println("This feature is already completed.");
    }
}

// Retrieve and Print All Pending Tasks Using Reflection
public class createTodo {
    public static void main(String[] args) {

        Class<Project> obj = Project.class;

        System.out.println("=== Pending Tasks ===");


        for (Method method : obj.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);


                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("---------------------------");
            }
        }
    }
}
