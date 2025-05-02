class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) {
                maxHeap.add(freq[i]);
            }
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