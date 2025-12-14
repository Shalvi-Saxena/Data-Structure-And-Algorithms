class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> dict = new HashMap<>();
        
        for(String word: words) {
            dict.put(word, dict.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue().equals(b.getValue())? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<String> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}