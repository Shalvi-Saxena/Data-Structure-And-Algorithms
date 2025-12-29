class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int i, int j) {
        int mid = i+ (j-i)/2;
        int right = nums[mid];
        int left = i;
        swap(nums, mid, j);
        for(int k=i; k<j; k++) {
            if(nums[k] > right) {
                swap(nums, left, k);
                left++;
            }
        }
        swap(nums, left, j);
        return left;
    }

    public int quickSort(int[] nums, int k, int start, int end) {
        int pivot = partition(nums, start, end);
        
        if(pivot == k) {
            return nums[pivot];
        } else if(pivot > k) {
            return quickSort(nums, k, start, pivot-1);
        } else {
            return quickSort(nums, k, pivot+1, end);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k-1, 0, nums.length-1);
    }
}
