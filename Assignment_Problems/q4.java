package Assignment_Problems;

public class q4
 {
    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Testing tokens = [3, 5, 5, 8, 6, 9]: index = " + firstBreak(tokens1));

        int[] tokens2 = {1, 2, 2, 7};
        System.out.println("Testing tokens = [1, 2, 2, 7]: index = " + firstBreak(tokens2));

        int[] customTokens = {4, 7, 7, 9, 5, 10};
        System.out.println("Testing custom tokens = [4, 7, 7, 9, 5, 10]: index = " + firstBreak(customTokens));
    }
}