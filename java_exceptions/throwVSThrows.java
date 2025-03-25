package java_exceptions;

import java.util.Scanner;

public class throwVSThrows {
    public static void calculateInterest(double amt, double rate, double years) throws IllegalArgumentException {
        if (amt < 0 || rate < 0 || years < 0) {
            throw new IllegalArgumentException("Invalid input: Amount, rate, and years must be positive.");
        }

        double SI = (amt * rate * years) / 100;
        System.out.print("Simple Interest is = " + SI + "%");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount = ");
        double amt = sc.nextDouble();
        System.out.println("Enter the rate = ");
        double rate = sc.nextDouble();
        System.out.println("Enter the time = ");
        double years = sc.nextDouble();

        calculateInterest(amt,rate,years);
        System.out.println("%");
    }
}