package WEEK_3;
import java.util.Arrays;

public class q1 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: calculate prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply by running suffix products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};

        System.out.println("Input: " + Arrays.toString(nums1) + " -> Output: " + Arrays.toString(productExceptSelf(nums1)));
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}