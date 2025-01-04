class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        // if(nums.length == 0)    return ranges;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            StringBuilder range = new StringBuilder();
            range.append(nums[i]);
            boolean flag = false;

            while(i < n-1 && nums[i]+1 == nums[i+1]) {
                i++;
                flag = true;
            }

            if(flag) {
                range.append("->");
                range.append(nums[i]);
            }
            ranges.add(String.valueOf(range));
        }

        return ranges;
    }
}