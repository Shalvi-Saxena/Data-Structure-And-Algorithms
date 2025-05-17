class MedianFinder {
    PriorityQueue<Integer> rightHeap;
    PriorityQueue<Integer> leftHeap;

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
    }
    
    public double findMedian() {
        if(leftHeap.size() == rightHeap.size()) {
            double sum = leftHeap.peek()+rightHeap.peek();
            return sum/2;
        }
        return leftHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */