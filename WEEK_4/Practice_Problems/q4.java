package Practice_Problems;

import java.util.Arrays;

public class q4 {
    // Merges two sorted arrays using the two-pointer approach
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result array

        // Compare elements and copy the smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of arr1, if any
        while (i < n1) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements of arr2, if any
        while (j < n2) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2))); // Output: [1, 2, 3, 4, 5, 6]

        // Test Case 2
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr3, arr4))); // Output: [1, 2, 3]
    }
}
