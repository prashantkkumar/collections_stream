package java_reflections.basic_reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class democlass{
    private final String name;
    private int age;

    democlass(String name, int i) {
        this.name = name;
        this.age = age;
    }
}
public class getclassinfo {
    public static void main(String[] args) throws Exception{
        democlass cl = new democlass("Prashant",22);
        Field[] fields = cl.getClass().getDeclaredFields();
        for(Field field:fields){
            System.out.println("Fields = " + field.getName());
        }

        Constructor[] constructor = cl.getClass().getDeclaredConstructors();
        for(Constructor constructor1:constructor){
            System.out.print("Constructor = " + constructor1.getName());
        }

        Method[] methods = cl.getClass().getMethods();
        for(Method method:methods){
            System.out.println("Methods = " + method.getName());
        }
    }
}
