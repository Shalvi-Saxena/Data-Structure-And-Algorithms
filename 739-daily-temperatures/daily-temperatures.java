class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitTime = new int[n];
        Stack<Integer> max = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!max.isEmpty() && temperatures[max.peek()] <= temperatures[i]) {
                max.pop();
            }
            if(max.isEmpty()) {
                waitTime[i] = 0;
            } else {
                waitTime[i] = max.peek()-i;
            }
            max.push(i);
        }
        
        return waitTime;
    }
}