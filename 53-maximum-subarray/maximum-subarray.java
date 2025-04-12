class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], left = 1;
        
        int res = sum;
        
        while(left < nums.length) {
            
            sum = Math.max(sum+nums[left], nums[left]); 
            res = Math.max(res, sum);
            left++;
        }
        
        return res;
    }
}