class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums.length == 0)    return ranges;
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i+1] - nums[i] == 1) {
                continue;
            } else {
                ranges.add(formatRange(nums[count],nums[i]));
                count = i+1;
            }
        }

        ranges.add(formatRange(nums[count], nums[nums.length - 1]));

        return ranges;
    }

    private String formatRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}