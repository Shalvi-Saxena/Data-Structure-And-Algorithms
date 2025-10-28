class Solution {
    public int rob(int[] nums, int i, int[] mem) {
        if(i<0) {
            return 0;
        }
        if(mem[i] >= 0) {
            return mem[i];
        }
        mem[i] = Math.max(rob(nums, i-2, mem)+nums[i], rob(nums, i-1, mem));
        return mem[i];
    }
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return rob(nums, nums.length-1, mem);
    }
}