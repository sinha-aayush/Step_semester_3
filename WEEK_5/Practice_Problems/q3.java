package WEEK_5.Practice_Problems;

public class q3 {
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            int current = scores[i];

            if (current >= first) {
                third = second; second = first; first = current;
            } else if (current >= second) {
                third = second; second = current;
            } else if (current >= third) {
                third = current;
            }
        }
        
        System.out.println("[" + first + ", " + second + ", " + third + "]");
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        findTopThreeScores(scores);
    }
}
