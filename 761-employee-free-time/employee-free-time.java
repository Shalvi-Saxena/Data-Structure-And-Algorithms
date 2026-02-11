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
        Interval temp = pq.poll();

        while(!pq.isEmpty()) {
            if(pq.peek().start > temp.end) {
                res.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll();
            } else if(pq.peek().end > temp.end) {
                temp = pq.poll();
            } else {
                pq.poll();
            }
        }

        return res;
    }
}