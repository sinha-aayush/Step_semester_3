package Practice_Problems;

public class q2 {
    // Calculates maximum profit using a single pass through the array
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update the lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today and update max profit
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // Output: 0
    }}
