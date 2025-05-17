class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for(int i=0; i<startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        return dfs(jobs, new int[startTime.length], 0);
    }

    public int dfs(int[][] jobs, int[] dp, int i) {
        if(i >= dp.length)  return 0;
        if(dp[i] != 0)  return dp[i];
        int next = findNext(jobs, jobs[i][1]);
        int take = jobs[i][2]+dfs(jobs, dp, next);
        int skip = dfs(jobs, dp, i+1);
        dp[i] = Math.max(take, skip);
        return dp[i];
    }

    public int findNext(int[][] jobs, int target) {
        int start=0, end = jobs.length;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(jobs[mid][0]>=target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}