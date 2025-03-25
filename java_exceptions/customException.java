package java_exceptions;

import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class CustomExceptionExample {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        } else {
            System.out.println("Access Granted!");
        }
    }
}

public  class customException {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the age = ");
            int age = sc.nextInt();
            CustomExceptionExample.validateAge(age);
        }
        catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        }

    }
}