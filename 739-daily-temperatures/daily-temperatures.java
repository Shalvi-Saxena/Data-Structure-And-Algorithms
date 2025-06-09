class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitTime = new int[n];
        Deque<Integer> max = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++) {
            while(!max.isEmpty() && temperatures[max.peek()] < temperatures[i]) {
                waitTime[max.peek()] = i-max.pop();
            }
            max.push(i);
        }
        
        return waitTime;
    }
}