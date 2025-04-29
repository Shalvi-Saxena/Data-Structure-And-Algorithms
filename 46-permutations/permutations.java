class Solution {
    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public List<List<Integer>> findComb(int[] nums, int start, List<List<Integer>> combinations) {
        if(start == nums.length) {
            List<Integer> combination = new ArrayList<>();
            for(int i: nums) {
                combination.add(i);
            }
            combinations.add(combination);
            return combinations;
        }
        for(int i=start; i<nums.length; i++) {
            swap(nums, start, i);
            combinations = findComb(nums, start+1, combinations);
            swap(nums, start, i);
        }

        return combinations;
    }
    public List<List<Integer>> permute(int[] nums) {
        return findComb(nums, 0, new ArrayList<>());
    }
}