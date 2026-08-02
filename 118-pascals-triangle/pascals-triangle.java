class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        int[] rowArr = new int[numRows];
        rowArr[0] = 1;
        
        for (int i = 0; i < numRows; i++) {
            rowArr[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                rowArr[j] = rowArr[j] + rowArr[j - 1];
            }
            
            List<Integer> rowList = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                rowList.add(rowArr[j]);
            }
            result.add(rowList);
        }
        
        return result;
    }
}