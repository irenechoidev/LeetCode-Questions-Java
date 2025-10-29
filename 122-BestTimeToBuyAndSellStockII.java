class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {

            if (minPrice < prices[i]) {
                maxProfit += prices[i] - minPrice;
            }

            minPrice = prices[i];
        }

        return maxProfit;
    }
}