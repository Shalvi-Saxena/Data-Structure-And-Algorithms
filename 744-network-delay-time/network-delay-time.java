class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> graph;
    private void bfs(int[] minTime, boolean[] isVisited, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        
        minTime[k] = 0;
        q.add(k);
        isVisited[k] = true;

        while(!q.isEmpty()) {
            int node = q.removeFirst();
            List<Pair<Integer, Integer>> edges = graph.getOrDefault(node, new ArrayList<>());
            for(Pair<Integer, Integer> edge: edges) {
                int dest = edge.getKey();
                int time = edge.getValue();
                int arrTime = time+minTime[node];

                if(arrTime < minTime[dest]) {
                    minTime[dest] = arrTime;
                    if(!isVisited[dest]) {
                        q.add(dest);
                        isVisited[dest] = true;
                    }                    
                }
            }
            isVisited[node] = false;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new HashMap<>();

        for(int[] edge: times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        int[] minTime = new int[n+1];
        boolean[] isVisited = new boolean[n+1]; 

        Arrays.fill(minTime, Integer.MAX_VALUE);
        bfs(minTime, isVisited, k);

        int totalTime = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {
            totalTime = Math.max(totalTime, minTime[i]);
        }

        return totalTime == Integer.MAX_VALUE? -1: totalTime;
    }
}