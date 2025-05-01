class Solution {
    public boolean checkIfExists(char[][] board, char[] str, int i, int j, int k, boolean[][] isVisited) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || k>=str.length || isVisited[i][j] || board[i][j] != str[k]) {
            return false;
        }

        isVisited[i][j] = true;
        k++;
        if( k==str.length )    return true;
        boolean isFound = checkIfExists(board, str, i+1, j, k, isVisited) || 
        checkIfExists(board, str, i-1, j, k, isVisited) ||
        checkIfExists(board, str, i, j-1, k, isVisited) ||
        checkIfExists(board, str, i, j+1, k, isVisited);

        isVisited[i][j] = false;
        return isFound;
    }

    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == str[0]) {
                    if(checkIfExists(board, str, i, j, 0, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}