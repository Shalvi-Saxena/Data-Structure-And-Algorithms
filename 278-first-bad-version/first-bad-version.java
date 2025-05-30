/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 1 || isBadVersion(1)) {
            return 1;
        }

        int start = 1, end = n;
        while(start < end) {
            int mid = ((end-start)/2) + start;
            if(isBadVersion(mid)) {
                if(!isBadVersion(mid-1)) {
                    return mid;
                }
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}