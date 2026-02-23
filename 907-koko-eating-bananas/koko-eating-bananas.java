class Solution {
    private boolean canFinish(int[] piles, int h, int k) {
        long hrs = 0;
        for(int i: piles) {
            hrs += i/k;
            if(i%k != 0) hrs++;
        }
        return hrs <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0, k=0;
        
        for(int i: piles) {
            max = Math.max(max, i);
        }

        k = max;

        while(min <= max) {
            int mid = min + (max-min)/2;
            int hrs = 0;
            if(canFinish(piles, h, mid)) {
                k = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return k;        
    }
}