class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                count ++;
            } else if(count >= 3) {
                List<Integer> tempRes = new ArrayList<>();
                tempRes.add(i-count);
                tempRes.add(i-1);
                res.add(tempRes);
                count = 1;
            } else {
                count = 1;
            }
        }

        if(count >= 3) {
            List<Integer> tempRes = new ArrayList<>();
            tempRes.add(s.length()-count);
            tempRes.add(s.length()-1);
            res.add(tempRes);
        }

        return res;
    }
}