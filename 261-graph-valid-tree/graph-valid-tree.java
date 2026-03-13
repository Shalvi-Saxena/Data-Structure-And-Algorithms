class Solution {
    private boolean isCycle(List<List<Integer>> graph, int i, int p, boolean[] isVisited) {
        if(isVisited[i]) return true;

        isVisited[i] = true;

        for(int item: graph.get(i)) {
            
            if(item == p)   continue;

            if(isCycle(graph, item, i, isVisited)) {
                return true;
            }
        }

        isVisited[i] = true;
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] isVisited = new boolean[n];

        if(isCycle(graph, 0, -1, isVisited)) {
            return false;
        }

        for(boolean visited: isVisited) {
            if(!visited) {
                return false;
            }
        }

        return true;
    }
}