class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums.length == 0)    return ranges;
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i+1] - nums[i] == 1) {
                continue;
            } else {
                ranges.add(count == i? nums[i]+"": nums[count]+"->"+nums[i]);
                count = i+1;
            }
        }

        if(count == nums.length-1) {
            ranges.add(nums[count]+"");
        } else {
            ranges.add(nums[count]+"->"+nums[nums.length-1]);
        }

        return ranges;
    }
}