class MinStack {
    // PriorityQueue<Integer> pq;
    Stack<Integer> stack;
    int min ;

    public MinStack() {
        // pq = new PriorityQueue<>();
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // pq.add(val);
        stack.push(val);
        min = Math.min(min, val);
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == min) {
            min = Integer.MAX_VALUE;
            for(Integer i: stack) {
                min = Math.min(i, min);
            }
        }     
    }
    
    public int top() {
        return stack.peek();        
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */