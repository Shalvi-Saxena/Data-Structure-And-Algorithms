class Solution {
    int m,n;
    public int getRow(int[][] matrix, int target) {
        int low = 0, high = m-1;
        
        if(target > matrix[high][n-1])  return -1;
        if(target < matrix[0][0])  return -1;
        
        while(low < high) {
            int mid = low+ (high-low)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1])
                return mid;
            else if(target >= matrix[mid+1][0])   low = mid+1;
            else    high = mid-1;
        }
        
        return low;
    }

    public int getIndex(int[][] matrix, int target, int row) {
        int low = 0, high = n-1;

        while(low < high) {
            int mid = low + (high-low)/2;
            if(matrix[row][mid] == target)  return mid;
            else if(target < matrix[row][mid])  high = mid-1;
            else    low = mid+1;
        }

        return matrix[row][low] == target? low: -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int row = getRow(matrix, target);
        if(row == -1)   return false;
        return getIndex(matrix, target, row) != -1;
    }
}