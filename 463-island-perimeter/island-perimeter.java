class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        // int size = grid.length;
        // int[][] gridTraversed = new int[size][size];

        for (int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1)
                    perimeter += getPerimeter(grid, i, j);
            }
        }
        return perimeter;
    }

    public int getPerimeter(int[][] grid, int i, int j) {
        int perimeter = 0;
        if(i == 0 || (i-1 >=0 && grid[i-1][j] == 0))
            perimeter += 1;
        if(i+1 == grid.length || (i+1 < grid.length && grid[i+1][j] == 0))
            perimeter += 1;
        if(j == 0 || (j-1 >= 0 && grid[i][j-1] == 0))
            perimeter += 1;
        if(j+1 == grid[0].length || (j+1 < grid[0].length && grid[i][j+1] == 0))
            perimeter += 1;
        return perimeter;
    }


}