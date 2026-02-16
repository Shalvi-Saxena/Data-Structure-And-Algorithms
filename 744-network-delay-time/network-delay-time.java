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
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        q.add(new int[]{k, 0});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            
            if(node[1] > minTime[node[0]])    continue;

            List<int[]> edges = graph.get(node[0]);
            for(int[] edge: edges) {
                int arrTime = minTime[node[0]]+edge[1];
                if(arrTime < minTime[edge[0]]) {
                    minTime[edge[0]] = arrTime;
                    q.add(new int[]{edge[0], arrTime});
                }
            }

        }
        
        int totalTime = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {
            if(minTime[i] == Integer.MAX_VALUE) return -1;
            totalTime = Math.max(totalTime, minTime[i]);
        }

        return totalTime;
    }
}