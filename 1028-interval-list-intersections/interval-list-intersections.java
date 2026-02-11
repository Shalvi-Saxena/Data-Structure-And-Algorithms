class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0, m = firstList.length, n = secondList.length;

        while(i < m && j < n) {
            if(secondList[j][0] <= firstList[i][1] && secondList[j][1] >= firstList[i][0]) {
                int s = Math.max(secondList[j][0], firstList[i][0]);
                int e = Math.min(secondList[j][1], firstList[i][1]);
                res.add(new int[] {s, e});
            }

            if(firstList[i][1] < secondList[j][1])  i++;
            else    j++;
        }

        return res.toArray(new int[res.size()][]);
    }
}