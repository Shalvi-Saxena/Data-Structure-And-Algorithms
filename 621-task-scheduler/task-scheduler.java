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
            int count = 0;
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<n+1 && !pq.isEmpty(); i++) {
                int time = pq.poll()-1;
                if(time > 0) {
                    temp.add(time);
                }
                count++;
            }
            for(int i:temp) {
                pq.add(i);
            }
            minCycle += pq.isEmpty()? count:(n+1);
        }

        return minCycle;
    }
}