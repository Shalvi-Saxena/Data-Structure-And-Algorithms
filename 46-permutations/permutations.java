class Solution {
    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public void findComb(int[] nums, int start, List<List<Integer>> combinations) {
        if(start == nums.length) {
            List<Integer> combination = new ArrayList<>();
            for(int i: nums) {
                combination.add(i);
            }
            combinations.add(combination);
            return;
        }
        for(int i=start; i<nums.length; i++) {
            swap(nums, start, i);
            findComb(nums, start+1, combinations);
            swap(nums, start, i);
        }

        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findComb(nums, 0, res);
        return res;
    }
}