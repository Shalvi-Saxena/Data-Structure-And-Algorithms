class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> spiralOrder = new ArrayList<>();

        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                spiralOrder.add(matrix[rowStart][j]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                spiralOrder.add(matrix[i][colEnd]);
            }
            if (rowStart < rowEnd) {
                for (int j = colEnd - 1; j >= colStart; j--) {
                    spiralOrder.add(matrix[rowEnd][j]);
                }
            }
            if (colStart < colEnd) {
                for (int i = rowEnd - 1; i > rowStart; i--) {
                    spiralOrder.add(matrix[i][colStart]);
                }
            }

            rowStart++; rowEnd--;
            colStart++; colEnd--;
        }

        return spiralOrder;
    }
}
