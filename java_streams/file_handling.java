import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
public class file_handling {
    public static void main(String[] args) {
        String scf = "source.txt";
        String destination = "destination.txt";

        copyFile(scf,destination);
    }
    public static  void  copyFile(String source,String destination){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Open source file for reading
            File sourceFile = new File(source);
            if (!sourceFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            fis = new FileInputStream(sourceFile);

            // Open destination file for writing (creates if it does not exist)
            fos = new FileOutputStream(destination);

            // Buffer to store bytes read from the file
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read and write bytes
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Close resources properly

            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }

    }
}
