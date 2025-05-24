class Solution {
    List<List<Integer>> res;
    public void getCombinations(int[] candidates, int target, List<Integer> comb, int i, int sum) {
        if(sum > target || i >= candidates.length)    return;
        if(sum == target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for(int j=i; j<candidates.length; j++) {
            if(sum+candidates[j] > target) {
                break;
            }
            comb.add(candidates[j]);
            getCombinations(candidates, target, comb, j, sum+candidates[j]);
            comb.remove(comb.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(candidates, target, new ArrayList<>(), 0, 0);   
        return res;
    }
}