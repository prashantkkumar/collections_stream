package java_reflections.basic_reflections;

import java.lang.reflect.Method;

class Calculator{
    private int multiply(int a, int b){
        return a*b;
    }
}
public class invokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator cl = new Calculator();
        Method method = cl.getClass().getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        int ans = (int)method.invoke(cl,4,5);
        System.out.println("Multiplication after invoking the private method is = "+ ans);
    }
}
