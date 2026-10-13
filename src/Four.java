import java.util.HashMap;
import java.util.Map;

public class Four {
    public static void main(String[] args) {
        String text = "Hello world, hello!";
        Map<String, Integer> wordCount = countOnlyLetters(text);

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countOnlyLetters(String text) {
        Map<String, Integer> map = new HashMap<>();

        if (text == null || text.trim().isEmpty()) {
            return map;
        }

        String lowerCaseText = text.toLowerCase();

        String[] words = lowerCaseText.split("[^a-z]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return map;
    }
}
