class Solution {
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<amount+1; i++) {
            for(int coin: coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }

        }
        
        // System.out.println(".  dp = "+Arrays.toString(dp));
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}