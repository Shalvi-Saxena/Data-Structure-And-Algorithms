class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if((sum & 1) == 1) {
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num: nums) {
            for(int i=target; i>=num; i--) {
                if(dp[i])   continue;
                if(dp[i-num]) dp[i] = true;
                if(dp[target])  return true;
            }
        }    
        
        return false;
    }
}