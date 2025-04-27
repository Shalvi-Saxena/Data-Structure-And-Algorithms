class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightProd = new int[n];
        int[] res = new int[n];
    
        rightProd[n-1] = 1;    
        for(int i=n-1; i>0; i--) {
            rightProd[i-1] = rightProd[i] * nums[i];
        }
        
        res[0] = rightProd[0];
        int leftProd = nums[0];

        for(int i=1; i<n-1; i++) {
            res[i] = leftProd*rightProd[i];
            leftProd *= nums[i];
        }

        res[n-1] = leftProd;
        
        return res;
    }
}