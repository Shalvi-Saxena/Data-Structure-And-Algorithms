class Solution {
    int m, n, l;
    public boolean dfs(char[][] board, int i, int j, char[] arr, int k, boolean[][] isVisited) {
        if(k>=l) {
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || isVisited[i][j] || board[i][j] != arr[k]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean isFound = dfs(board, i-1, j, arr, k+1, isVisited) ||
        dfs(board, i+1, j, arr, k+1, isVisited) ||
        dfs(board, i, j-1, arr, k+1, isVisited) ||
        dfs(board, i, j+1, arr, k+1, isVisited);
        isVisited[i][j] = false;
        return isFound;
    }

    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        m = board.length;
        n = board[0].length;
        l = arr.length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == arr[0]) {
                    if(dfs(board, i, j, arr, 0, new boolean[m][n])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}