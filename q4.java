package WEEK_3;

import java.util.Arrays;
import java.util.HashMap;

public class q4 {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Base case: empty prefix sum has a sum of 0 occurring once
        prefixSumCounts.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            // Check if (currentSum - k) exists in the map
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        int[] nums2 = {1, -1, 0};
        int k2 = 0;

        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1 + " -> Output: " + subarraySum(nums1, k1));
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2 + " -> Output: " + subarraySum(nums2, k2));
    }
}