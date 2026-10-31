package WEEK_10.Assignment_Problems;

public class q4 {
    public static int countInBand(int[] scores, int low, int high) {
        int firstIndex = findFirstGreaterOrEqual(scores, low);
        if (firstIndex == -1) {
            return 0;
        }
        int lastIndex = findFirstGreaterThan(scores, high);
        if (lastIndex == -1) {
            return scores.length - firstIndex;
        }
        return lastIndex - firstIndex;
    }

    private static int findFirstGreaterOrEqual(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static int findFirstGreaterThan(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low = 42, high = 58;
        int result = countInBand(scores, low, high);
        System.out.println("Expected Output: " + result);
    }
}
