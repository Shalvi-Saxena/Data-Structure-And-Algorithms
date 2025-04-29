class Solution {
    public List<List<Integer>> findComb(int[] nums, List<Integer> combination, List<List<Integer>> combinations) {
        if(combination.size() == nums.length) {
            combinations.add(new ArrayList<Integer>(combination));
            return combinations;
        }
        for(int i=0; i<nums.length; i++) {
            if(combination.contains(nums[i]))   continue;
            combination.add(nums[i]);
            combinations = findComb(nums, combination, combinations);
            combination.remove(combination.size() - 1);
        }

        return combinations;
    }
    public List<List<Integer>> permute(int[] nums) {
        return findComb(nums, new ArrayList<Integer>(), new ArrayList<>());
    }
}