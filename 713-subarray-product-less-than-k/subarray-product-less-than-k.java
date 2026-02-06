class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0, count = 0;
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);

        for(int i=0; i<nums.length; i++) {
            
            for(int j=i; j>=left; j--) {
                
                if(prod[j]*nums[i] >= k) {
                    left = j+1;
                    break;
                }
                prod[j] *= nums[i];
                count++;
            }
        }

        return count;
    }
}