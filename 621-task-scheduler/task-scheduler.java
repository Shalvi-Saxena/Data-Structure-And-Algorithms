class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(Character task: tasks) {
            count.putIfAbsent(task, 0);
            int i = count.get(task);
            count.put(task, i+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for(Integer val: count.values()) {
            maxHeap.add(val);
        }
        while(!maxHeap.isEmpty()) {
            List<Integer> newHeap = new ArrayList<>();
            int task=0, cycle=n+1;

            while(cycle-- > 0 && !maxHeap.isEmpty()) {
                int currTask = maxHeap.poll();
                if(currTask > 1)    newHeap.add(currTask-1);
                task++;
            }

            for(int i: newHeap) {
                maxHeap.add(i);
            }

            time += (maxHeap.isEmpty())? task: n+1;
        }
        return time;
    }
}