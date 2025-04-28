class Solution {
    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + ((end-start)/2);

        System.out.println("start = "+start+" mid = "+mid+" end = "+end);

        if(start > end) {
            return -1;
        }
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] < target && nums[end] >= target) {
            return binarySearch(nums, mid+1, end, target);
        } else if(nums[mid] < target && nums[end] <= target) {
            return binarySearch(nums, start, mid-1, target);
        } else if(nums[mid] < target && nums[end] <= target) {
            return binarySearch(nums, start, mid-1, target);
        } else if(nums[mid] > target && nums[start] <= target) {
            return binarySearch(nums, start, mid-1, target);
        } else {
            return binarySearch(nums, mid+1, end, target);
        }
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