package Assignment_Problems;

import java.util.Arrays;

public class q5
 {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }
        
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v == 6 ? "" : " "));
        }
        System.out.println();
        
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted1 = diceSort(rolls1);
        System.out.println("Sorted: " + Arrays.toString(sorted1));

        int[] customRolls = {3, 5, 2, 3, 1, 6, 3, 2};
        int[] sortedCustom = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}