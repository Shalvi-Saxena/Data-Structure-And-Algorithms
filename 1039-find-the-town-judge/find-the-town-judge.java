class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] townTrustee = new boolean[n];
        int[] townTruster = new int[n];

        for(int i=0; i<trust.length; i++) {
            townTrustee[trust[i][0]-1] = true;
            townTruster[trust[i][1]-1] = townTruster[trust[i][1]-1]+1;
        }

        for(int i=0; i<n; i++) {
            if(!townTrustee[i] && townTruster[i] == n-1) {
                return i+1;
            }
        }

        return -1;
    }
}