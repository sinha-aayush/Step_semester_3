package WEEK_3;

import java.util.Arrays;

public class q2 {

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend current running sum or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-3, -1, -2};

        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + maxSubArray(nums1));
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + maxSubArray(nums2));
    }
}