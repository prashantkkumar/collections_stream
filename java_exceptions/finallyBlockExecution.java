package java_exceptions;

import java.util.Scanner;

public class finallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number = ");
        int a = sc.nextInt();
        System.out.println("Enter the second number = ");
        int b = sc.nextInt();

        try {
            int div = a/b;
            System.out.println("Division of two number is = "+div);
        } catch (ArithmeticException e) {
            System.out.println("Denominator cant be zero");
        }
        finally {
            System.out.println("Operation Completed!");
        }
    }
}