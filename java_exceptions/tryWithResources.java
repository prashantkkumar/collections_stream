package java_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tryWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt"; // File name

        // Try-with-resources to auto-close BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine(); // Read the first line
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}