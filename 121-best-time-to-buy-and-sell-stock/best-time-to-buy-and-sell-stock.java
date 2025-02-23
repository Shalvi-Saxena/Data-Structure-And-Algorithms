class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min = prices[0];
        for(int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(prices[i]-min, profit);
        }
        return profit;
    }
}