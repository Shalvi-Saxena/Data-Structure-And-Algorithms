class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i){
        int j = nums.length - 1;

        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // Step 1: find breakpoint
        while(i >= 0 && nums[i] >= nums[i+1])
            i--;

        // Step 2: swap with next greater element
        if(i >= 0){

            int j = nums.length - 1;

            while(nums[j] <= nums[i])
                j--;

            swap(nums,i,j);
        }

        // Step 3: reverse suffix
        reverse(nums,i+1);
    }
}