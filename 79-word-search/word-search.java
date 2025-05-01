class Solution {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] str = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] str, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
            board[i][j] != str[k]) {
            return false;
        }

        if (k == str.length - 1) return true;

        board[i][j] = '#';

        for (int[] dir : DIRECTIONS) {
            int ni = i + dir[0], nj = j + dir[1];
            if (dfs(board, str, ni, nj, k + 1)) {
                return true;
            }
        }

        board[i][j] = str[k];
        return false;
    }
}
