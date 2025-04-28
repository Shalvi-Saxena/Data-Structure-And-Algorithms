class Solution {
    public void sortColors(int[] nums) {
        int i,j;
        for(i=0, j=nums.length-1; i<nums.length && j>i; i++) {
            if(nums[i] != 0) {
                while(j>i && nums[j] != 0) {
                    j--;
                }
                if(i!=j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                // System.out.println("nums "+Arrays.toString(nums)+" i = "+i+" j = "+j);
            }
        }
        i = 0;
        while(i<nums.length && nums[i] == 0) i++;
        // System.out.println("nums "+Arrays.toString(nums)+" i = "+i);
        for(j=nums.length-1; i<nums.length && j>i; i++) {
           if(nums[i] != 1) {
                while(j>i && nums[j] != 1) {
                    j--;
                }
                if(j>i) {
                    nums[j] = nums[i];
                    nums[i] = 1;
                }
            } 
        }
    }
}