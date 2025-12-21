class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0;
        int[] max = new int[n];

        for(int i=n-1; i>=0; i--) {
            max[i] = 1;
            for(int j=i+1; j<n; j++) {
                if(nums[i] < nums[j]) {
                    max[i] = Math.max(max[j]+1, max[i]);
                }
            }
            maxLen = Math.max(maxLen, max[i]);
        }

        return maxLen;
    }
}