class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=1) {
            return Arrays.asList(0);
        }
        List<HashSet<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int key=0; key<n; key++) {
            if(graph.get(key).size() == 1) {
                queue.add(key);
            }
        }

        int remainingNodes = n;

        while(remainingNodes>2) {
            remainingNodes -= queue.size();
            int size = queue.size();
            while(size-- > 0) {
                int key = queue.poll();
                for(int node: graph.get(key)) {
                    graph.get(node).remove(key);
                    graph.get(key).remove(node);
                    if(graph.get(node).size() == 1) {
                        queue.add(node);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}