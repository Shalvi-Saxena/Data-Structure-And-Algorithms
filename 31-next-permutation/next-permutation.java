class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public int findNextSmallest(int[] nums, int i) {
        int small = i+1;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] < nums[j] && nums[small] >= nums[j]) {
                small = j;
            }
        }
        return nums[small] >= nums[i]? small:i;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int bp = n-2;

        while(bp>=0 && nums[bp]>=nums[bp+1]) bp--;

        if(bp<0) {
            reverse(nums, 0, n-1);
        } else {
            int small = findNextSmallest(nums, bp);
            if(small == bp) {
                reverse(nums, bp+1, n-1);
            } else {
                swap(nums, small, bp);
                reverse(nums, bp+1, n-1);
            }
        }
    }
}