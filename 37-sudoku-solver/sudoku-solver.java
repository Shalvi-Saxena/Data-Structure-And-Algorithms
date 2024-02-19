class Solution {
    
    int N;
    char[][] board;
    int[] rowsIndex = new int[]{0,0,0,3,3,3,6,6,6};
    int[] colsIndex = new int[]{0,0,0,3,3,3,6,6,6};
    
    public boolean isValidNum(int row, int col, char num, boolean[] repeatedNums) {
        
            boolean flag = false;
            for(int i=0; !flag && i<9; i++) {
                
                if(board[row][i] == num) return false;
                if(board[i][col] == num) return false;
            }
            
            int row1 = rowsIndex[row], col1 = colsIndex[col];
            
            for(int x = row1; x<row1+3; x++) {
                for(int y = col1; y<col1+3; y++) {
                    if( board[x][y]  == num) return false;           
                }
            }
        
        return true;
    }
    
    public boolean backTrackFill(int row, int col, boolean[] repeatedNums) {
        if(row == N-1 && col == N) {
            return true;
        }
        
        if(col == N) {
            row ++;
            col=0;
            repeatedNums = new boolean[10];
        }
        
        while(board[row][col] != '.') {
            repeatedNums[board[row][col]-'0'] = true;
            col++;
            if(col == N) {
                row ++;
                col=0;
                repeatedNums = new boolean[10];
            }
            if(row == N) return true;
        }
        
        for(char i='1'; i<=N+'0'; i++) {
            if(repeatedNums[i-'0'-1]) continue;
            if(isValidNum(row, col, i, repeatedNums)) {
                board[row][col] = i;
                repeatedNums[i-'0'] = true;
                if(backTrackFill(row, col+1, repeatedNums)) {
                    return true;
                }
            }
            board[row][col] = '.';
            repeatedNums[i-'0'] = false;
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        N = board.length;
        this.board = board;
        backTrackFill(0, 0, new boolean[10]);
    }
    
    
}