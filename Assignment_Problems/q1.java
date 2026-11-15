package Assignment_Problems;

import java.util.Arrays;

public class q1 {
    public static void lineUp(int[] heights) {
        int n = heights.length;
        boolean swapped;
        int pass = 1;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
            pass++;
        }
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Testing heights = [4, 2, 5, 1]:");
        lineUp(heights1);
        
        System.out.println();
        
        int[] heights2 = {1, 3, 2, 4};
        System.out.println("Testing heights = [1, 3, 2, 4]:");
        lineUp(heights2);

        System.out.println();
        
        int[] customInput = {5, 3, 8, 4, 2};
        System.out.println("Testing custom input = [5, 3, 8, 4, 2]:");
        lineUp(customInput);
    }
}