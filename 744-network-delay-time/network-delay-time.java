class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(k);

        while(!q.isEmpty()) {
            int node = q.removeFirst();
            List<int[]> edges = graph.get(node);
            for(int[] edge: edges) {
                int arrTime = minTime[node]+edge[1];
                if(arrTime < minTime[edge[0]]) {
                    minTime[edge[0]] = arrTime;
                    q.add(edge[0]);
                }
            }

        }
        
        int totalTime = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {
            totalTime = Math.max(totalTime, minTime[i]);
        }

        return totalTime == Integer.MAX_VALUE? -1: totalTime;
    }
}