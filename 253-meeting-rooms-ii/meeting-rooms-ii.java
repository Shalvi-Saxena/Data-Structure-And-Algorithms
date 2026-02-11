class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1)   return intervals.length;

        int[][] s = new int[intervals.length*2][2];
        int i=0;

        for(int[] meet: intervals) {
            s[i++] = new int[]{meet[0], 1};
            s[i++] = new int[]{meet[1], -1};
        }

        Arrays.sort(s, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int rooms=0, max=0;

        for(int[] st: s) {
            rooms += st[1];
            max = Math.max(max, rooms);
        }

        return max;
    }
}