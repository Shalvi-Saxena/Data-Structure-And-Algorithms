class Solution {
    class Node {
        public int d;
        public long t;
        Node(int d, long t) {
            this.d = d;
            this.t = t;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Node>> graph = new ArrayList<>();
        int MOD = 1000000007;
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        for(int[] road: roads) {
            graph.get(road[0]).add(new Node(road[1], road[2]));
            graph.get(road[1]).add(new Node(road[0], road[2]));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a, b)-> Long.compare(a.t, b.t));

        
        q.add(new Node(0, 0));
        dist[0] = 0;
        ways[0] = 1;

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.t > dist[node.d])   continue;

            for(Node dst: graph.get(node.d)) {
                
                long t = dst.t + node.t;

                if(t < dist[dst.d]) {
                    dist[dst.d] = t;
                    ways[dst.d] = ways[node.d];
                    q.add(new Node(dst.d, t));
                } else if(t == dist[dst.d]) {
                    ways[dst.d] += ways[node.d];
                    ways[dst.d] %= MOD;
                }

            }
        }

        return (int)ways[n-1];
    }
}