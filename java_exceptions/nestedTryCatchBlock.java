package java_exceptions;

public class nestedTryCatchBlock {
    public static void main(String[] args) {
        try {
            int a[] = { 1, 2, 3, 4, 5 };
            System.out.println(a[5]);
            try {
                int x = a[2] / 0; // This will throw ArithmeticException
            } catch (ArithmeticException e2) {
                System.out.println("Cannot divide by zero!");
            }
        }catch(ArrayIndexOutOfBoundsException e1) {
            System.out.println("Invalid array index!");
        }
    }

}
