class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, i=0, j=0;

        while(j<n && nums[j] != 0) {
            j++;
        }
        
        for(i=j+1; i<n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            nums[j] = nums[i];
            nums[i] = 0;
            while(nums[j] != 0) {
                j++;
            }
        }

        for(i=j; i<n; i++) {
            nums[i] = 0;
        }
    }
}