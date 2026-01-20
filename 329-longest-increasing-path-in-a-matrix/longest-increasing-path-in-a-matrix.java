class Solution {
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] grid = new int[m][n];
        int ans = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, dfs(matrix, grid, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] grid, int i, int j) {
        if(grid[i][j] != 0) return grid[i][j];

        int ans = 1;

        if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(matrix, grid, i-1, j));
        }
        if(i+1 < m && matrix[i+1][j] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(matrix, grid, i+1, j));
        }
        if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(matrix, grid, i, j-1));
        }
        if(j+1 < n && matrix[i][j+1] < matrix[i][j]) {
            ans = Math.max(ans, 1+dfs(matrix, grid, i, j+1));
        }
        grid[i][j] = ans;
        return ans;
    }
}