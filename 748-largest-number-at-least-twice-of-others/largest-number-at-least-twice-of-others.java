class Solution {
    public int dominantIndex(int[] nums) {
        int a = 1, b = 0;

        if(nums[0]>nums[1]) {
            a = 0;
            b = 1;
        }

        for(int i=0; i<nums.length; i++) {
        // System.out.println("Nums a "+nums[a]+" b "+nums[b]);
            if(nums[i] > nums[a]) {
                b = nums[a] >= nums[b]? a:b;
                a = i;
            }
            if(nums[i] > nums[b] && nums[i] < nums[a]) {
                b = i;
            }
        }

        // System.out.println("Nums a "+nums[a]+" b "+nums[b]);

        return nums[a] >= (2* nums[b])? a:-1;
    }
}