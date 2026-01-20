class Solution {
    int m,n;
    int[][] matrix, grid;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        grid = new int[m][n];
        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        return ans;
    }

    private int dfs(int i, int j) {
        if(grid[i][j] != 0) return grid[i][j];

        int ans = 1;

        if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(i-1, j));
        }
        if(i+1 < m && matrix[i+1][j] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(i+1, j));
        }
        if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(i, j-1));
        }
        if(j+1 < n && matrix[i][j+1] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(i, j+1));
        }
        grid[i][j] = ans;
        return ans;
    }
}