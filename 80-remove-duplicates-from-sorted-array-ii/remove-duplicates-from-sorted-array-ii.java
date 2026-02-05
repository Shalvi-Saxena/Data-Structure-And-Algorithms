class Solution {
    public int removeDuplicates(int[] nums) {
        int dup = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1])    dup++;
            else dup = 1;
            if(dup == 2) {
                int j=i;
                while(i<nums.length-1 && nums[i+1] == nums[j]) {
                    nums[i+1] = Integer.MAX_VALUE;
                    i++;
                }
                dup = 1;
            }
        }

        int i=0, j=0;
        while(i<nums.length && nums[i] != Integer.MAX_VALUE) {
            i++;       
        }
        j=i;
        for(; i<nums.length; i++) {
            if(nums[i] != Integer.MAX_VALUE) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}