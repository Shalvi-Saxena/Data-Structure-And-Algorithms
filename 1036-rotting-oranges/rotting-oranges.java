class Solution {
    private int[][] markRotten(int[][] grid, int i, int j) {
        if(i>0 && grid[i-1][j] == 1) {
            grid[i-1][j] = 2;
        }
        if(j>0 && grid[i][j-1] == 1) {
            grid[i][j-1] = 2;
        }
        if(i<grid.length-1 && grid[i+1][j] == 1) {
            grid[i+1][j] = 2;
        }
        if(j<grid[0].length-1 && grid[i][j+1] == 1) {
            grid[i][j+1] = 2;
        }
        return grid;
    }
    public int orangesRotting(int[][] grid) {
        int min = 0, m = grid.length, n = grid[0].length;
        int fresh = 0, rotten = 0;
        List<int[]> bfs = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    rotten++;
                    bfs.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!bfs.isEmpty()) {
            List<int[]> nextBfs = new ArrayList<>();
            for(int[] pair: bfs) {
                int i = pair[0], j = pair[1];
                if(i>0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    rotten++; fresh--;
                    nextBfs.add(new int[]{i-1,j});
                }
                if(j>0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    rotten++; fresh--;
                    nextBfs.add(new int[]{i,j-1});
                }
                if(i<grid.length-1 && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    rotten++; fresh--;
                    nextBfs.add(new int[]{i+1,j});
                }
                if(j<grid[0].length-1 && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    rotten++; fresh--;
                    nextBfs.add(new int[]{i,j+1});
                }
            }
            if(!nextBfs.isEmpty()) {
                min++;
            }
            bfs = nextBfs;
        }

        return fresh != 0? -1:min;
    }
}