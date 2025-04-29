class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)   return intervals;

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        List<int[]> arr = new ArrayList<>();
        for(int[] i: intervals) {
            // System.out.println(i[0]+".  "+i[1]);
            if(arr.isEmpty()) {
                arr.add(i);
                continue;
            }
            if(arr.get(arr.size()-1)[1] >= i[0]) {
                arr.get(arr.size()-1)[1] = Math.max(arr.get(arr.size()-1)[1], i[1]);
                arr.get(arr.size()-1)[0] = Math.min(arr.get(arr.size()-1)[0], i[0]);
            } else {
                arr.add(i);
            }
        }
        int[][] finalIntervals = new int[arr.size()][2];
        int i=0;
        for(int[] item: arr) {
            finalIntervals[i++] = item;
        }
        return finalIntervals;
    }
}