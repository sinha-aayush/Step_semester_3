package Practice_Problems;

public class q2 {

    // Approach 1: Iterative
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        
        return new String(chars).equals(new String(reversed));
    }

    public static void checkAndPrint(String text) {
        String iterRes = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recurRes = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayRes = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Input: \"" + text + "\"");
        System.out.println("Iterative: " + iterRes + " | Recursive: " + recurRes + " | Array Reversal: " + arrayRes);
        System.out.println();
    }

    public static void main(String[] args) {
        checkAndPrint("madam");
        checkAndPrint("hello");
    }
}
