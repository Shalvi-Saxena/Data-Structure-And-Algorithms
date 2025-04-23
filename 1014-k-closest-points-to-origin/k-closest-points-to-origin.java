class Solution {
    public int getSqrDist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> getSqrDist(b) - getSqrDist(a));
        int i=0;
        for(int[] point: points) {
            if(i++<k) {
                heap.offer(point);
            } else {
                if(getSqrDist(point) < getSqrDist(heap.peek())) {
                    heap.poll();
                    heap.offer(point);
                }
            }
        }

        return heap.toArray(new int[k][]);
    }
}