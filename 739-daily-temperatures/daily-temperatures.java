class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitTime = new int[n];
        Deque<Integer> max = new ArrayDeque<>();

        for(int i=n-1; i>=0; i--) {
            while(!max.isEmpty() && temperatures[max.peek()] <= temperatures[i]) {
                max.pop();
            }
            waitTime[i] = max.isEmpty()? 0:max.peek()-i;
            max.push(i);
        }
        
        return waitTime;
    }
}