class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> task = new HashMap<>();
        for(char ch: tasks) {
            task.put(ch, task.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char key: task.keySet()) {
            pq.add(task.get(key));
        }

        int minCycle = 0;

        while(!pq.isEmpty()) {
            int cycle=n+1, s = pq.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<cycle && !pq.isEmpty(); i++) {
                int time = pq.poll()-1;
                if(time > 0) {
                    temp.add(time);
                }
            }
            if(pq.isEmpty() && temp.size() == 0) {
                minCycle += s;
            } else {
                minCycle += cycle;
            }
            for(int i:temp) {
                pq.add(i);
            }
        }

        return minCycle;
    }
}