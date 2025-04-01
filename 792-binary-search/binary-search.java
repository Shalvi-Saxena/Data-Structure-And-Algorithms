class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length, mid = (end-start)/2;

        while(start < end) {
            if(nums[mid] == target) {
                return mid;
            }
            if (end - start == 1)   break; 
            if(target > nums[mid]) {
                start = mid;
                mid = ((end-start)/2)+start;
            } else {
                end = mid;
                mid = ((end-start)/2)+start;
            }
            // System.out.println("start "+start+". end "+end+". mid "+mid);
        }
        return -1;
    }
}