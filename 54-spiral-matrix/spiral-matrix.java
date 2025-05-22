class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int startRow = 0, endRow = matrix.length-1;
        int startCol = 0, endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int i=startCol; i<=endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            for(int i=startRow+1; i<=endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            if(startRow < endRow) {
                for(int i=endCol-1; i>=startCol; i--) {
                    res.add(matrix[endRow][i]);
                }
            }
            if(startCol < endCol) {
                for(int i=endRow-1; i>startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
            }
            startRow++; endRow--;
            startCol++; endCol--;
        }

        return res;
    }
}