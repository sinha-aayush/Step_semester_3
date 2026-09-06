package Practice_Problems;

import java.util.HashMap;

public class q4 {

    public static char findFirstNonRepeatingChar(String text) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with frequency 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // Return null character if no non-repeating character is found
    }

    public static void processString(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("Input: \"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + text + "\" -> No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        processString("swiss");
        processString("aabbcc");
    }
}
