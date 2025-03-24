import java.io.*;
public class Readfilelinebyline {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Update with actual file path
        readErrorLines(filePath);
    }
    public static void readErrorLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
