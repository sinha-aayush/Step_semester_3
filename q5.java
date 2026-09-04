package WEEK_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q5 {
    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");

        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}