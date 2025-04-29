class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int index = 0;

        for (int i=1; i<intervals.length; i++) {
            if(intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        int[][] merged = new int[index+1][2];
        for(int i=0; i<=index; i++) {
            merged[i] = intervals[i];
        }

        return merged;
    }
}
