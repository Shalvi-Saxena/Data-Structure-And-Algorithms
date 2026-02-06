class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, gap = Integer.MAX_VALUE;

        for(int i=0; i<nums.length-2 && gap != 0; i++) {
            int j=i+1, k=nums.length-1;
            int currTar = target-nums[i];

            while(j<k) {
                if(Math.abs(currTar - nums[j] - nums[k]) < gap ) {
                    sum = nums[i]+nums[j]+nums[k];
                    gap = Math.abs(currTar - nums[j] - nums[k]);
                }
                if((currTar - nums[j] - nums[k]) > 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}