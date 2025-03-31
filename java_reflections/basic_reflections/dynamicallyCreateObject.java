package java_reflections.basic_reflections;

import java.lang.reflect.Constructor;

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class dynamicallyCreateObject {
    public static void main(String[] args) throws Exception {
        String classname = "java_reflections.basic_reflections.Student";
        Class<?> cl = Class.forName(classname);
        Constructor<?> constructor = cl.getDeclaredConstructor(String.class, int.class);
        Object instance = constructor.newInstance("Prashant",22);
        System.out.println("Operation after performing the new keyword = "+instance);
    }
}
