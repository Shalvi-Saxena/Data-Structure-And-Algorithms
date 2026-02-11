class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <= 1)   return true;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);
        for(int[] interval: intervals) {
            pq.add(interval);
        }

        int[] meet = pq.poll();

        while(!pq.isEmpty()) {
            int[] nextMeet = pq.poll();

            if(nextMeet[0] < meet[1]) {
                return false;
            }

            meet = nextMeet;
        }

        return true;
    }
}