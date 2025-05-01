class Solution {
    public void createSubsets(int[] nums, int i, List<Integer> subset, List<List<Integer>> superSet) {
        if(nums.length == i) {
            superSet.add(new ArrayList<Integer>(subset));
            return;
        }

        subset.add(nums[i]);
        createSubsets(nums, i+1, subset, superSet);
        subset.remove(subset.size()-1);
        createSubsets(nums, i+1, subset, superSet);

        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> superSet = new ArrayList<>();
        createSubsets(nums, 0, new ArrayList<Integer>(), superSet);
        return superSet;
    }
}