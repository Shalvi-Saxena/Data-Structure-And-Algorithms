class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void findComb(int[] nums, int start, List<List<Integer>> combList) {
        if(start == nums.length) {
            List<Integer> comb = new ArrayList<>();
            for(int i: nums) {
                comb.add(i);
            }
            combList.add(comb);
            return;
        }

        for(int i=start; i<nums.length; i++) {
            swap(nums, start, i);
            findComb(nums, start+1, combList);
            swap(nums, start, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> combList = new ArrayList<>();
        findComb(nums, 0, combList);
        return combList;
    }
}