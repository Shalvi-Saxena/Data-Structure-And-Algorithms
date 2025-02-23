class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        // for(int i=0; i<prices.length-1; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         profit = Math.max(prices[j]-prices[i], profit);
        //     }
        // }

        int min = prices[0];

        for(int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(prices[i]-min, profit);
        }
        return profit;
    }
}