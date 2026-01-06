class Solution {
    int m, n;
    int[][] dp;
    boolean[][] isVisited;

    public int getMaxSquare(char[][] matrix, int i, int j) {
        if( i<0 || j<0 ) return 0;
        if (isVisited[i][j]) return dp[i][j];

        isVisited[i][j] = true;

        if (matrix[i][j] == '0') {
            dp[i][j] = 0;
            return 0;
        }
        
        int left = getMaxSquare(matrix, i-1, j);
        int top = left>0? getMaxSquare(matrix, i, j-1):0;
        int diag = top>0? getMaxSquare(matrix, i-1, j-1):0;
        dp[i][j] = 1 + Math.min(left, Math.min(top, diag));

        return dp[i][j];
    }
    public int maximalSquare(char[][] matrix) {
        int count = 0;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        isVisited = new boolean[m][n];

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int size = getMaxSquare(matrix, i, j);
                count = Math.max(count, size*size);
            }
        }
        return count;
    }
}