package Piped_StreamThread;
import java.io.*;
public class PipedStreamsDemo {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);

            reader.start();
            writer.start();

        } catch (IOException e) {
            System.out.println("Piping Error: " + e.getMessage());
        }
    }
}
