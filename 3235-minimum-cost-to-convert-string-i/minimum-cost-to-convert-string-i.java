class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] min = new int[26][26];
        int inf = Integer.MAX_VALUE;

        for(int i=0; i<26; i++) {
            Arrays.fill(min[i], inf);
            min[i][i] = 0;
        }

        for(int i=0; i<original.length; i++) {
            int s = original[i]-'a';
            int t = changed[i]-'a';
            min[s][t] = Math.min(min[s][t], cost[i]);
        }

        for(int k=0; k<26; k++) {
            for(int i=0; i<26; i++) {
                if(min[i][k] == inf)    continue;
                for(int j=0; j<26; j++) {
                    if(min[k][j] == inf)    continue;
                    min[i][j] = Math.min(min[i][k]+min[k][j], min[i][j]);
                }
            }
        }

        long c = 0;

        for(int i=0; i<source.length(); i++) {
            int s = source.charAt(i)-'a', t = target.charAt(i)-'a';
            if(min[s][t] == inf) {
                return -1;
            }
            c += min[s][t];
        }

        return c;
    }
}