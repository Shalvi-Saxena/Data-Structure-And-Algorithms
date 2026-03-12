class Solution {
    private void getSubsets(List<List<Integer>> res, int[] nums, int i, List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        while(i<nums.length) {
            curr.add(nums[i]);
            getSubsets(res, nums, i+1, curr);
            curr.remove(curr.size()-1);
            i++;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getSubsets(res, nums, 0, new ArrayList<>());
        return res;
    }
}