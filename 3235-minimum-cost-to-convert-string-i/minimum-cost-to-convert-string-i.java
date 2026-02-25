class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long[][] dist = new long[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2); // avoid overflow
            dist[i][i] = 0;
        }

        // Build graph
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]); // in case multiple edges
        }

        // Floyd-Warshall: all pairs shortest path
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Convert strings
        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        long totalCost = 0;

        for (int i = 0; i < src.length; i++) {
            int u = src[i] - 'a';
            int v = tar[i] - 'a';
            if (u == v) continue;
            if (dist[u][v] >= Long.MAX_VALUE / 2) return -1;
            totalCost += dist[u][v];
        }

        return totalCost;
    }
}