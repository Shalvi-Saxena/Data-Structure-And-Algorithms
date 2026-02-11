/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start-b.start);
        for(List<Interval> interval: schedule) {
            pq.addAll(interval);
        }

        List<Interval> res = new ArrayList<>();
        Interval start = pq.poll();

        while(!pq.isEmpty()) {
            Interval temp = pq.poll();
            if(temp.start > start.end) {
                res.add(new Interval(start.end, temp.start));
            } 
            if(temp.end > start.end) {
                start = temp;
            } 
        }

        return res;
    }
}