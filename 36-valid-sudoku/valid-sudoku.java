class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int k = board[i][j] - '1';
                if(k<0 || k>9)  continue;
                int gridN = (i/3) + (j/3)*3;
                if(rows[i][k] || cols[j][k] || grid[gridN][k]) {
                    return false;
                }
                rows[i][k] = true;
                cols[j][k] = true;
                grid[gridN][k] = true;
            }
        }

        return true;
    }
}