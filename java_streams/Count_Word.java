import java.util.*;
import java.io.*;
public class Count_Word {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Update with actual file path
        countWords(filePath);
    }

    public static void countWords(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (!word.isEmpty()) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue() - a.getValue());

        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            if (count < 5) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}
