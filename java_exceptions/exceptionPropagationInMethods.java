package java_exceptions;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class exceptionPropagationInMethods {
    public static void method1() throws ArithmeticException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number 1 = ");
        int a = sc.nextInt();
        System.out.println("Enter the number 2 = ");
        int b = sc.nextInt();
        int div = a/b;
        System.out.println("Division is = "+ div);
    }
    public static void method2(){
        method1();
    }
    public static void main(String[] args) {
        try {
            method2();
        }
        catch (ArithmeticException e){
            System.out.println("Handled exception in main");
        }
    }
}