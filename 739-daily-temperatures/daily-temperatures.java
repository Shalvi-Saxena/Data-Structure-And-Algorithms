class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitTime = new int[n];
        waitTime[n-1] = 0;
        Stack<Integer> max = new Stack<>();
        max.push(n-1);

        for(int i=n-2; i>=0; i--) {
            while(!max.isEmpty() && temperatures[max.peek()] <= temperatures[i]) {
                max.pop();
            }
            if(max.isEmpty()) {
                max.push(i);
                waitTime[i] = 0;
            } else {
                waitTime[i] = max.peek()-i;
                max.push(i);
            }
        }
        
        return waitTime;
    }
}