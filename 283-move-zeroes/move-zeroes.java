class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, i=0, j=0;

        // while(j<n && nums[j] != 0) {
        //     j++;
        // }
        
        for(i=0; i<n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            nums[j] = nums[i];
            j+=1;
        }

        for(i=j; i<n; i++) {
            nums[i] = 0;
        }
    }
}