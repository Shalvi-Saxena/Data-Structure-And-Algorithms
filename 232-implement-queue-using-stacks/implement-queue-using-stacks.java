class MyQueue {
    Stack<Integer> queue;
    Stack<Integer> backUp;

    public MyQueue() {
        queue = new Stack<>();
        backUp = new Stack<>();
    }
    
    public void push(int x) {
        while(!queue.empty()) {
            backUp.push(queue.pop());
        }
        queue.push(x);
        while(!backUp.empty()) {
            queue.push(backUp.pop());
        }
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */