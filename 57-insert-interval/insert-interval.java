class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals.length == 0) {
            int[][] res = {{newInterval[0], newInterval[1]}};
            return res;
        }

        int i=0;
        List<int[]> res = new ArrayList<>();

        // Smaller intervals
        while(i<intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // Overlapping intervals
        while(i<intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Larger intervals
        while(i<intervals.length) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}