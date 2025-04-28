class Solution {
    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + ((end-start)/2);

        if(start > end) {
            return -1;
        }
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return binarySearch(nums, start, mid-1, target);
        }

        return binarySearch(nums, mid+1, end, target);
    }

    public int search(int[] nums, int target) {
        if(nums[0] == target) {
            return 0;
        }
        int i;
        for(i=1; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
            if(nums[i-1]>nums[i]) {
                break;
            }
        }

        return binarySearch(nums, i, nums.length-1, target);
    }
}