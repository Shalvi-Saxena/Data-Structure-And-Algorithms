class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int beg = -1, end = -2, n = nums.length;
        int min = nums[n-1], max = nums[0];

        for(int i=1; i<n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n-i-1], min);
            if(nums[i] < max)   end = i;
            if(nums[n-i-1] > min)   beg = n-i-1;
        }

        return end-beg+1;
    }
}