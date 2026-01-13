class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<=k; i++) {
            int[] temp = dist.clone();
            for(int[] flight: flights) {
                int s = flight[0], d = flight[1], p = flight[2];
                if(dist[s] < Integer.MAX_VALUE) {
                    temp[d] = Math.min(temp[d], p+dist[s]);
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE? -1: dist[dst];
    }
}