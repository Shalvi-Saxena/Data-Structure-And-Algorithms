class Solution {
    public int bouquetMade(int[] bloomDay, int mid, int k) {
        int count = 0, b = 0;

        for(int i: bloomDay) {
            if(i>mid) {
                count = 0;
            } else {
                count++;
                if(count == k) {
                    b++;
                    count = 0;
                }
            }
        }
        return b;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) {
            return -1;
        }
        
        int low = 1, high = -1, ans = -1;

        for(int i: bloomDay) {
            high = Math.max(i, high);
        }

        while(low <= high) {
            int mid = (low + high)/2;
            int b = bouquetMade(bloomDay, mid, k);
            if(b >= m) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }

        }


        return ans;
    }
}