class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1)   return intervals.length;

        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] meet: intervals) {
            map.put(meet[0], map.getOrDefault(meet[0], 0)+1);
            map.put(meet[1], map.getOrDefault(meet[1], 0)-1);
        }

        int curr = 0, max = 0;

        for(int i: map.values()) {
            curr += i;
            max = Math.max(max, curr);
        }

        return max;
    }
}