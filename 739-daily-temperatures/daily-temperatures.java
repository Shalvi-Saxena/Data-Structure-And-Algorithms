class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitTime = new int[n];
        Stack<Integer> max = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!max.isEmpty() && temperatures[max.peek()] < temperatures[i]) {
                waitTime[max.peek()] = i-max.peek();
                max.pop();
            }
            max.push(i);
        }
        
        return waitTime;
    }
}