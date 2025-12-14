class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> dict = new HashMap<>();
        
        for(String word: words) {
            dict.put(word, dict.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue().equals(b.getValue())? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()
        );
        
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            pq.offer(entry);
        }

        List<String> res = new ArrayList<>();

        for(int i=0; i<k; i++) {
            res.add(pq.poll().getKey());
        }

        return res;
    }
}