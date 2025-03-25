package java_exceptions;

import java.util.Scanner;

public class multipleCatchBlocks {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of array = ");
            int size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter the elements of array = ");
            for(int i=0;i<size;i++){
                arr[i]  =sc.nextInt();
            }
            System.out.println("Enter the index number = ");
            int ind = sc.nextInt();
            System.out.println("Value at index "+ind+" is "+ arr[ind]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index!");
        }
        catch (NullPointerException g){
            System.out.println("Array is not initialized");
        }
    }
}