class Solution {

    public boolean calcDist(int[] arr1, int[] arr2) {
        double dist = Math.hypot((arr1[0]-arr2[0]), (arr1[1]-arr2[1]));
        return dist <= arr1[2];
    }

    public int DFS(int[][] bombs, boolean[] visited, int count, int i) {
        count += 1;
        int count1 = count;
        visited[i] = true;

        for(int j=0; j<bombs.length; j++) {
            if(!visited[j] && calcDist(bombs[i], bombs[j])) {
                count1 = DFS(bombs, visited, count1, j);
            }
        }

        // visited[i] = false;

        return count1;
    }
    public int maximumDetonation(int[][] bombs) {
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<bombs.length; i++) {
            
            max = Math.max(max, DFS(bombs, new boolean[bombs.length], 0, i));
            // System.out.println("i = "+i+" max = "+max);
        }
        return max;
    }
}