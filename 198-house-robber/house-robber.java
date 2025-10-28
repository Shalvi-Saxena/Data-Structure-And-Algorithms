class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length+1];
        mem[0] = 0;
        mem[1] = nums[0];

        for(int i=2; i<=nums.length; i++) {
            mem[i] = Math.max(nums[i-1]+mem[i-2], mem[i-1]);
        }
        return mem[nums.length];
    }
}