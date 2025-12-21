class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0;

        for(int i=0; i<nums.length; i++) {
            int j = nums[i], tempCount = 1;
            if(set.contains(j-1)) {
                continue;
            }
            while(set.contains(j+1)) {
                set.remove(j);
                j++;
                tempCount++;
            }

            max = Math.max(tempCount, max);
        }

        return max;
    }
}