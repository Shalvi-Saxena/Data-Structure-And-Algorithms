import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Integer[] dp = new Integer[n];
        return dfs(0, jobs, dp);
    }

    private int dfs(int i, int[][] jobs, Integer[] dp) {
        if (i == jobs.length) return 0;
        if (dp[i] != null) return dp[i];
        int nextIndex = binarySearch(jobs, jobs[i][1]);
        int take = jobs[i][2] + dfs(nextIndex, jobs, dp);
        int skip = dfs(i + 1, jobs, dp);
        return dp[i] = Math.max(take, skip);
    }

    private int binarySearch(int[][] jobs, int target) {
        int low = 0, high = jobs.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
