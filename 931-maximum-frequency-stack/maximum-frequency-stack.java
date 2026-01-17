class FreqStack {

    class Node {
        int freq, ind, val;
        Node(int freq, int ind, int val) {
            this.freq = freq;
            this.ind = ind;
            this.val = val;
        }
    }

    HashMap<Integer, Integer> map;
    PriorityQueue<Node> stack;
    int ind;

    public FreqStack() {
        map = new HashMap<>();
        stack = new PriorityQueue<>((a,b)-> {
            if(a.freq == b.freq) {
                return Integer.compare(b.ind, a.ind);
            }
            return Integer.compare(b.freq, a.freq);
        });
        ind = 0;
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0)+1;
        map.put(val, freq);
        stack.offer(new Node(freq, ind++, val));        
    }
    
    public int pop() {
        int val = stack.poll().val;
        map.put(val, map.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */