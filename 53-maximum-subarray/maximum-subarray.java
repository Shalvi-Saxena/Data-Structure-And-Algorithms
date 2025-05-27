class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int currSum = nums[0], maxSum = nums[0];
        for(int left=0, right=1; right<nums.length && left<=right; right++) {
            currSum += nums[right];
            while(left <= right && currSum < nums[right]) {
                currSum -= nums[left++];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return Math.max(currSum, maxSum);
    }
}