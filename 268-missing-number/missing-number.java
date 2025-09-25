class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0, sum2 = nums.length, n = nums.length;
        for(int i=0; i<n; i++) {
            sum1 += nums[i];
            sum2 += i;
        }

        return sum2-sum1;
    }
}