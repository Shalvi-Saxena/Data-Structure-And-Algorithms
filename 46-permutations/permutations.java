class Solution {
    public void swap(int[] nums, int j, int k) {
        int a = nums[j];
        nums[j] = nums[k];
        nums[k] = a;
    }
    public void permute(int[] nums, List<Integer> perm, List<List<Integer>> res, int i) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int j=i; j<nums.length; j++) {
            perm.add(nums[j]);
            permute(nums, perm, res, j+1);
            perm.remove(perm.size()-1);

            for(int k=j+1; k<nums.length; k++) {
                swap(nums, j, k);
                perm.add(nums[j]);
                permute(nums, perm, res, j+1);
                swap(nums, j, k);
                perm.remove(perm.size()-1);
            }
        }
        return; 
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, new ArrayList<>(), res, 0);
        return res;
    }
}