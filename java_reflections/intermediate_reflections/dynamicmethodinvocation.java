package java_reflections.intermediate_reflections;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperation{
    public void add(double a, double b){
        System.out.println(a+b);
    }
    public void sub(double a, double b){
        System.out.println(a-b);
    }
    public void mul(double a, double b){
        System.out.println(a*b);
    }
}
public class dynamicmethodinvocation {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the method name = ");
        String methodName = sc.next();
        System.out.println("Enter the input 1 = ");
        double a = sc.nextDouble();
        System.out.println("Enter the input 2 = ");
        double b = sc.nextDouble();

        MathOperation mm = new MathOperation();
        Method method = mm.getClass().getDeclaredMethod(methodName,double.class,double.class);
        System.out.println(method.invoke(mm,a,b));

    }
}
