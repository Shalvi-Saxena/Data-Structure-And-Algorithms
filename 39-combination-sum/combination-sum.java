class Solution {
    public List<List<Integer>> findCombination(int[] candidates, int target, int sum, List<Integer> path, int i, List<List<Integer>> res) {
        if(sum == target) {
            res.add(new ArrayList<>(path));
            // System.out.print("sum = "+sum+" path = "+path+" res = "+res);
            return res;
        }
        if(sum>target) return res;

        for(int j = i; j<candidates.length; j++) {
            if(sum+candidates[j] > target)  continue;
            path.add(candidates[j]);
            res = findCombination(candidates, target, sum+candidates[j], path, j, res);
            path.remove(Integer.valueOf(candidates[j]));
        }
        return res;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        return findCombination(candidates, target, 0, new ArrayList<Integer>(), 0, res);
    }
}