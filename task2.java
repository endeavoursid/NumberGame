import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task2 {
    private Map<String, Integer> wordFrequency;

    private static final String[] COMMON_WORDS = {
            "the", "and", "is", "of", "in", "to", "with", "for", "it", "on"
            // Add more common words as needed
    };

    public task2() {
        wordFrequency = new HashMap<>();
    }

    public void countWords(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase();
            if (!isCommonWord(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
    }

    private boolean isCommonWord(String word) {
        for (String commonWord : COMMON_WORDS) {
            if (word.equals(commonWord)) {
                return true;
            }
        }
        return false;
    }

    public void showStatistics() {
        int totalWords = wordFrequency.values().stream().mapToInt(Integer::intValue).sum();
        int uniqueWords = wordFrequency.size();

        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords + "\n");

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String inputText = scanner.nextLine();

        task2 wordCounter = new task2();
        wordCounter.countWords(inputText);
        wordCounter.showStatistics();
    }
}
