class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] townTrustee = new boolean[n];
        int[] townTruster = new int[n];

        for(int[] item: trust) {
            townTrustee[item[0]-1] = true;
            townTruster[item[1]-1] = townTruster[item[1]-1]+1;
        }

        for(int i=0; i<n; i++) {
            if(!townTrustee[i] && townTruster[i] == n-1) {
                return i+1;
            }
        }

        return -1;
    }
}