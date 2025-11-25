class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, prod = 1;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i<n; i++) {
            prod *= nums[i];
            left[i] = prod;
            if(prod == 0) {
                prod = 1;
            }
        }

        prod = 1;

        for(int i=n-1; i>=0; i--) {
            prod *= nums[i];
            right[i] = prod;
            if(prod == 0) {
                prod = 1;
            }
        }

        int maxProd = Math.max(left[0], right[0]);
        for(int i=1; i<n; i++) {
            maxProd = Math.max(maxProd, Math.max(left[i], right[i]));
        }

        return maxProd;
    }
}