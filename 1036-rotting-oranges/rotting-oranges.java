class Solution {
    public int addFreshOrange(int[][] grid, int i, int j, int m, int n, List<int[]> nextLevel, int fresh) {
        if(i-1 >= 0 && grid[i-1][j] == 1) {
            grid[i-1][j] = 2;
            nextLevel.add(new int[]{i-1, j});
            fresh--;
        }
        if(i+1 < m && grid[i+1][j] == 1) {
            grid[i+1][j] = 2;
            nextLevel.add(new int[]{i+1, j});
            fresh--;
        }
        if(j-1 >= 0 && grid[i][j-1] == 1) {
            grid[i][j-1] = 2;
            nextLevel.add(new int[]{i, j-1});
            fresh--;
        }
        if(j+1 < n && grid[i][j+1] == 1) {
            grid[i][j+1] = 2;
            nextLevel.add(new int[]{i, j+1});
            fresh--;
        }
        return fresh;
    }
    public int orangesRotting(int[][] grid) {
        List<int[]> level = new ArrayList<>();
        int min = 0, m = grid.length, n = grid[0].length, fresh = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    level.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!level.isEmpty()) {
            List<int[]> nextLevel = new ArrayList<>();
            
            for(int[] item: level) {
                fresh = addFreshOrange(grid, item[0], item[1], m, n, nextLevel, fresh);
            }
            if(nextLevel.size() > 0) {
                min++;
            }
            level = nextLevel;
        }
        return fresh == 0? min: -1;
    }
}