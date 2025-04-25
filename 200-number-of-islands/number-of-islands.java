class Solution {
    boolean[][] isVisited;
    public char[][] dfs(char[][] grid, int i, int j, int m, int n) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0' || isVisited[i][j]) {
            return grid;
        }
        isVisited[i][j] = true;
        grid[i][j] = '0';
        grid = dfs(grid, i+1, j, m, n);
        grid = dfs(grid, i, j+1, m, n);
        grid = dfs(grid, i-1, j, m, n);
        grid = dfs(grid, i, j-1, m, n);

        return grid;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        isVisited = new boolean[m][n];
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !isVisited[i][j]) {
                    grid = dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }
}