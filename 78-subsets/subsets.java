class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for(List subset: subsets) {
                List<Integer> tempSet = new ArrayList<Integer> (subset);
                tempSet.add(nums[i]);
                newSubsets.add(tempSet);
            }
            subsets.addAll(newSubsets);
        }

        return subsets;
    }
}