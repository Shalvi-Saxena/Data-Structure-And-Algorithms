class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxSum = 0;
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        maxSum = sum;
        for(int i=k, j=0; i<nums.length; i++, j++) {
            sum += nums[i] - nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum/k;
    }
}