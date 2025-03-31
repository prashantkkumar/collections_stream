package java_reflections.basic_reflections;

import java.lang.reflect.Field;

class Person{
    private int age;

    Person(int i) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
public class accessprivatefield {
    public static void main(String[] args) throws Exception {
        System.out.println("Initial Age is = ");
        Person me = new Person(21);
        Field[] fields = me.getClass().getDeclaredFields();

        for(Field fl:fields){
            fl.setAccessible(true);
            fl.set(me,22);
        }

        System.out.println("Updated Age is = "+me.getAge());
    }
}
