class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1) {
            res.add(0);
            return res;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;  degree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leafNodes.add(i);
            }
        }

        int remainingNodes = n;

        while(n > 2) {
            List<Integer> newLeafNodes = new ArrayList<>();
            n -= leafNodes.size();

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

        return leafNodes;
    }
}