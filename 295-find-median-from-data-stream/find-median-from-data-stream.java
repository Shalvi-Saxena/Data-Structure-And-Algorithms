class MedianFinder {
    PriorityQueue<Integer> rightHeap;
    PriorityQueue<Integer> leftHeap;
    double med = 0;

    public MedianFinder() {
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        leftHeap.add(num);
        rightHeap.add(leftHeap.poll());

        if(rightHeap.size() > leftHeap.size()) {
            leftHeap.add(rightHeap.poll());
        }
        if(leftHeap.size() == rightHeap.size()) {
            med = (leftHeap.peek()+rightHeap.peek())/2.0;
        } else {
            med = leftHeap.peek();
        }
    }
    
    public double findMedian() {
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */