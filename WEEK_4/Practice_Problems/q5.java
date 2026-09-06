package Practice_Problems;

import java.util.Arrays;

public class q5 {
    // Rotates the array to the right by k steps using modulo arithmetic
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        k = k % n; // Handle cases where k is greater than length
        int[] rotated = new int[n];

        // Map elements to their new indices
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(rotateArray(nums1, k1))); // Output: [5, 6, 7, 1, 2, 3, 4]

        // Test Case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println(Arrays.toString(rotateArray(nums2, k2))); // Output: [2, 1]
    }
}
