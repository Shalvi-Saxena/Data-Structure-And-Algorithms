class Solution {
    public void DFS(int[][] image, int sr, int sc, int color, int ogColor, boolean[][] isVisited) {
        if(sr < 0 || sr >= image.length)
            return;
        if(sc < 0 || sc >= image[0].length)
            return;
        if(image[sr][sc] != ogColor)
            return;
        if(isVisited[sr][sc])
            return;
        image[sr][sc] = color;
        isVisited[sr][sc] = true;
        DFS(image, sr-1, sc, color, ogColor, isVisited);
        DFS(image, sr+1, sc, color, ogColor, isVisited);
        DFS(image, sr, sc-1, color, ogColor, isVisited);
        DFS(image, sr, sc+1, color, ogColor, isVisited);
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] isVisited = new boolean[image.length][image[0].length];
        DFS(image, sr, sc, color, image[sr][sc], isVisited);

        return image;
    }
}