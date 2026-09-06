package Practice_Problems;

public class q3 {
    // Checks if any element appears at least twice using nested loops
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Return true immediately upon finding a duplicate
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1)); // Output: true

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2)); // Output: false
    }
}
