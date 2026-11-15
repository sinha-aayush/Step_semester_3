package Practice_Problems;

public class q10 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);
        System.out.print("length = " + len + ", nums[0.." + (len - 1) + "] = [");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + (i == len - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}