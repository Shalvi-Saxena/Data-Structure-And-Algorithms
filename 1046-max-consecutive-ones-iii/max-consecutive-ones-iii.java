class Solution {
    public int longestOnes(int[] nums, int k) {
        int countZ = 0, max = 0;

        for(int left=0, i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                countZ++;
            }

            while(countZ > k) {
                if(nums[left++] == 0) {
                    countZ--;
                }
            }

            max = Math.max(max, i-left+1);
        }

        return max;
    }
}