package Assignment_Problems;

import java.util.Arrays;

public class q2 {
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1) + " swaps = " + swaps1);

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2) + " swaps = " + swaps2);

        int[] customMarks = {30, 50, 20, 90, 10};
        int customSwaps = prizeTable(customMarks);
        System.out.println(Arrays.toString(customMarks) + " swaps = " + customSwaps);
    }
}