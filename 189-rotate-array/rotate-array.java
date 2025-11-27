class Solution {
    public void rotate(int[] nums, int k) {
        if (k==0) {
            return;
        }

        int i,j,n = nums.length;
        k = k%n;

        int[] arr = new int[k];

        for(i=n-k, j=0; i<n; i++,j++) {
            arr[j] = nums[i];
        }

        for(i=n-1, j=n-1-k; j>=0; i--,j--) {
            nums[i] = nums[j];
        }

        for(i=0; i<k; i++) {
            nums[i] = arr[i];
        }
    }
}