class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> graph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leafNodes.add(i);
            }
        }

        while(!leafNodes.isEmpty()) {
            res = leafNodes;
            List<Integer> newLeafNodes = new ArrayList<>();

            for(int node: leafNodes) {
                if(graph.get(node).size() == 1) {
                    int parent = graph.get(node).iterator().next();
                    graph.get(parent).remove(node);
                    if(graph.get(parent).size() == 1) {
                        newLeafNodes.add(parent);
                    }
                    graph.get(node).remove(parent);
                }
            }
            leafNodes = newLeafNodes;
        }

        return res;
    }
}