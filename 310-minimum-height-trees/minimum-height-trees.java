class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=1) {
            return Arrays.asList(0);
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(Integer key: graph.keySet()) {
            if(graph.get(key).size() <= 1) {
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
                    if(graph.get(node).size() == 1) {
                        queue.add(node);
                    }
                }
                graph.remove(key);
            }
        }

        return new ArrayList<>(queue);
    }
}