class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>());

        for(int i=0; i<nums.length; i++) {
            int size = powerSet.size();
            for(int j=0; j<size; j++) {
                List<Integer> tempSet = new ArrayList<>(powerSet.get(j));
                tempSet.add(nums[i]);
                powerSet.add(tempSet);
            }
        }

        return powerSet;
    }
}