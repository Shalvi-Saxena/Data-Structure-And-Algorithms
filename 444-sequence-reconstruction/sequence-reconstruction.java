class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] isPrev = new boolean[nums.length];
        boolean[] isVisited = new boolean[nums.length];
        int i=0;

        for(int num: nums) {
            map.put(num, i++);
        }

        for(List<Integer> seq: sequences) {
            int prev = -1;

            for(Integer num: seq) {
                if(!map.containsKey(num)) {
                    return false;
                }
                int ind = map.get(num);
                if(ind < prev) {
                    return false;
                }
                isPrev[ind] = isPrev[ind] || (ind-prev == 1);
                isVisited[ind] = true;
                prev = ind;
            }
        }
        isPrev[0] = true;

        for(i=0; i<nums.length; i++) {
            if(isPrev[i] && isVisited[i]) {
                continue;
            }
            return false;
        }
        return true;
    }
}