class Solution {
    class Node {
        int dist;
        int val;
        Node(int dist, int val) {
            this.dist = dist;
            this.val = val;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> {
            if(a.dist != b.dist) {
                return Integer.compare(b.dist, a.dist);
            } 
            return Integer.compare(b.val, a.val);
        });

        for(int i=0; i<arr.length; i++) {
            int dist = Math.abs(arr[i]-x);
            heap.add(new Node(dist, arr[i]));
            if(heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i=0; i<k; i++) {
            res.add(heap.poll().val);
        }

        Collections.sort(res);

        return res;
    }
}