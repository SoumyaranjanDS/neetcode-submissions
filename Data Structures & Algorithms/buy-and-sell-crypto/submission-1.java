class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bestBuys = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (maxProfit < prices[i] - bestBuys) {
                maxProfit = Math.max(maxProfit, prices[i] - bestBuys);
            }
            bestBuys = Math.min(bestBuys, prices[i]);
        }
        return maxProfit;
    }
}
