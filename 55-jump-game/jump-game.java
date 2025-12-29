class Solution {
    public boolean canJump(int[] nums) {
        int maxIndx = 0;
        boolean[] isJump = new boolean[nums.length];

        for(int i=0; i<nums.length && i<=maxIndx; i++) {
            if(maxIndx >= i) {
                isJump[i] = true;
            }
            maxIndx = Math.max(i+nums[i], maxIndx);
        }
        return isJump[nums.length-1];
    }
}