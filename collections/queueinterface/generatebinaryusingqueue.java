package collections.queueinterface;
import java.util.*;

public class generatebinaryusingqueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1"); // Initialize queue with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll(); // Get the front element
            result.add(current); // Store in result

            queue.add(current + "0"); // Enqueue next binary number
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> binaryNumbers = generateBinaryNumbers(n);
        System.out.println(binaryNumbers);
    }
}
