import java.io.*;
public class buffer_file_copy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        // Measure time for Buffered Streams
        long startTime = System.nanoTime();
        copyUsingBufferedStreams(sourceFile, destBuffered);
        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure time for Unbuffered Streams
        startTime = System.nanoTime();
        copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void copyUsingBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer size
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void copyUsingUnbufferedStreams(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer size
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
