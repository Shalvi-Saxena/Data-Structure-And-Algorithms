class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)    return true;
        if(edges.length == 0)   return false;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] nodes = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(source);

        while(!q.isEmpty()) {
            int node = q.removeFirst();
            List<Integer> ver = graph.get(node);
            nodes[node] = true;

            for(int i: ver) {
                if(i == destination)    return true;
                if(!nodes[i]) {
                    q.add(i);
                    nodes[i] = true;
                }
            }
        }

        return false;
    }
}