class Solution {
    int[] sq = {0,1,4,9,16,25,36,49,64,81};
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n > 1) {
            int currSum = 0;
            if(set.contains(n)) {
                return false;
            }
            set.add(n);
            while(n>0) {
                currSum += sq[n%10];
                n /= 10;
            }
            n = currSum;
        }
        return true;
    }
}