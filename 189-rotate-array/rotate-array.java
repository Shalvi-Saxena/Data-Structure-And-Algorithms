class Solution {
    public void rotate(int[] nums, int k) {
        int i,j,n = nums.length;
        k = k%n;

        if (k==0) {
            return;
        }

        int[] arr = new int[n];

        for(i=0; i<n; i++) {
            arr[(i+k)%n] = nums[i];
        }

        for(i=0; i<n; i++) {
            nums[i] = arr[i];
        }
    }
}