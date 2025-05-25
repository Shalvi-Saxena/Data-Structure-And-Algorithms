class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightProd = new int[n];
        int[] prod = new int[n];
        rightProd[n-1] = 1;

        for(int i=n-1; i>0; i--) {
            rightProd[i-1] = nums[i]*rightProd[i];
        }
        int leftProd = 1;
        for(int i=0; i<n; i++) {
            prod[i] = leftProd*rightProd[i];
            leftProd *= nums[i];
        }

        return prod;
    }
}