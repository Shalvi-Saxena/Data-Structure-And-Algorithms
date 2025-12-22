class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;
        for(int num: set) {
            if(set.contains(num-1)) {
                continue;
            }
            int j = num, tempCount = 1;
            while(set.contains(j+1)) {
                j++;
                tempCount++;
            }

            max = Math.max(tempCount, max);
        }

        return max;
    }
}