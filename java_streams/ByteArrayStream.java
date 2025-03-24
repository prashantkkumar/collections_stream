import java.io.*;
import java.nio.file.Files;
public class ByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";
        String outputImagePath = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Write byte array back to image
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image successfully converted and written to " + outputImagePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer size
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
