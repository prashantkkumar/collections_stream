package java_exceptions;
import java.util.*;

public class uncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int div = 0;
        try {
            System.out.println("Enter a number");
            int a = sc.nextInt();
            int b = sc.nextInt();
            div = a / b;
            System.out.println("Division of a and b is = " + div);
        } catch (ArithmeticException e) {

            System.out.println("Denominator cannot be zero");
        } catch (InputMismatchException g) {
            System.out.println("Enter a valid numeric value");
        }
    }
}