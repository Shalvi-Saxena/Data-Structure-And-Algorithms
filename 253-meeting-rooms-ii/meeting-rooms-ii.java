class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1)   return intervals.length;

        int[] s = new int[intervals.length];
        int[] e = new int[intervals.length];
        int i=0;

        for(int[] meet: intervals) {
            s[i] = meet[0];
            e[i++] = meet[1];
        }

        Arrays.sort(s);
        Arrays.sort(e);

        int rooms=0;
        i=0;

        for(int st: s) {
            if(st >= e[i]) {
                rooms--;
                i++;
            }
            rooms++;
        }

        return rooms;
    }
}