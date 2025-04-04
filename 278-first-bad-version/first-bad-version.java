/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) {
            return 1;
        }

        int start = 1, end = n;
        while(start < end) {
            int mid = ((end-start)/2) + start;
            if(isBadVersion(mid)) {
                if(mid == 1 || !isBadVersion(mid-1)) {
                    return mid;
                }
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}