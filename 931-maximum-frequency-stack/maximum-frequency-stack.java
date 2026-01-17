class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Deque<Integer>> list;
    int maxFreq;

    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        list = new HashMap<>();
    }
    
    public void push(int val) {
        int currFreq = freq.getOrDefault(val, 0)+1;
        maxFreq = Math.max(maxFreq, currFreq);
        freq.put(val, currFreq);

        if(!list.containsKey(currFreq)) {
            list.put(currFreq, new ArrayDeque<>());
        }
        list.get(currFreq).addLast(val);
    }
    
    public int pop() {
        Deque<Integer> currList = list.get(maxFreq);
        int val = currList.removeLast();
        freq.put(val, maxFreq-1);
        
        if(currList.isEmpty()) {
            maxFreq -= 1;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */