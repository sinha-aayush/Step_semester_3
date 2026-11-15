package Practice_Problems;

public class q6 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxPro) {
                    maxPro = profit;
                }
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
}