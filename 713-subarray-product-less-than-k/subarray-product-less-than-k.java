class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)    return 0;

        int left=0, count = 0;
        long currProd = 1;

        for(int i=0; i<nums.length; i++) {
            currProd *= nums[i];
            
            while(currProd >= k && left<=i) {
                currProd /= nums[left++];
            }

            count += i-left+1;
        }

        return count;
    }
}