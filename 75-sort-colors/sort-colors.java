class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right) {
            while(left<right && nums[left] == 0) {
                left++;
            } 
            while(left<right && nums[right] != 0) {
                right--;
            }
            if(left < right) {
                int num = nums[left];
                nums[left] = nums[right];
                nums[right] = num;
                left++;
                right--;
            }
        }
        right = nums.length-1;
        left=0;

        while(left<right && nums[left] == 0)  left++;

        while(left < right) {
            while(left<right && nums[left] == 1) {
                left++;
            } 
            while(left<right && nums[right] != 1) {
                right--;
            }
            if(left < right) {
                int num = nums[left];
                nums[left] = nums[right];
                nums[right] = num;
                left++;
                right--;
            }
        }
    }
}