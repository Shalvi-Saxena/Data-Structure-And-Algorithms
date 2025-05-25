class Solution {
    int m, n;
    public void markVisited(char[][] grid, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        markVisited(grid, i-1, j);
        markVisited(grid, i+1, j);
        markVisited(grid, i, j-1);
        markVisited(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    markVisited(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}