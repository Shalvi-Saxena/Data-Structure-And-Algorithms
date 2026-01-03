class Solution {
    List<Integer> result = new ArrayList<>();
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses && !hasCycle; i++) {
            if (!visited[i]) {
                dfs(i, graph);
            }
        }

        if (hasCycle) return new int[0];

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(numCourses - 1 - i);
        }

        return order;
    }

    private void dfs(int node, List<Integer>[] graph) {
        if (onPath[node]) {
            hasCycle = true;
            return;
        }
        if (visited[node] || hasCycle) return;

        onPath[node] = true;

        for (int next : graph[node]) {
            dfs(next, graph);
        }

        onPath[node] = false;
        visited[node] = true;
        result.add(node);
    }
}
