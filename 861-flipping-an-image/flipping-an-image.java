class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i=0; i<image.length; i++) {
            for (int j=0, k=image.length-1; j<=k; j++, k--) {
                int temp = image[i][j];
                image[i][j] = image[i][k] == 0? 1:0;
                if(j!=k) {
                    image[i][k] = temp == 0? 1:0;
                }
            }

        }
        return image;
    }
}