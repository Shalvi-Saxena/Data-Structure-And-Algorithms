class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> (b + a).compareTo(a + b));
        for(int num: nums) {
            pq.offer(String.valueOf(num));
        }
        if(pq.peek().equals("0"))   return "0";
        
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()) {
            res.append(pq.poll());
        }

        return res.toString();
    }
}