class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        
        for(int n: nums) {
            for(int i = target; i>=n; i--) {
                if(dp[i])   continue;
                if(dp[i-n]) dp[i] = true;
                if(dp[target])  return true;
            }
        }

        return false;
    }
}