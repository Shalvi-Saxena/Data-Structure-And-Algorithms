class Solution {
    public List<List<Integer>> findComb(int[] nums, List<Integer> combination, HashSet<Integer> queue, List<List<Integer>> combinations) {
        if(combination.size() == nums.length) {
            combinations.add(new ArrayList<Integer>(combination));
            return combinations;
        }
        for(int i=0; i<nums.length; i++) {
            if(queue.contains(nums[i]))   continue;
            combination.add(nums[i]);
            queue.add(nums[i]);
            combinations = findComb(nums, combination, queue, combinations);
            combination.remove(combination.size() - 1);
            queue.remove(nums[i]);
        }

        return combinations;
    }
    public List<List<Integer>> permute(int[] nums) {
        return findComb(nums, new ArrayList<Integer>(), new HashSet<Integer>(), new ArrayList<>());
    }
}