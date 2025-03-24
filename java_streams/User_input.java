import java.io.*;
public class User_input {
    public static void main(String[] args) {
        String fileName = "user_data.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName, true)) { // Append mode

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Writing data to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");
            writer.write("-------------------------\n");

            System.out.println("User data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
