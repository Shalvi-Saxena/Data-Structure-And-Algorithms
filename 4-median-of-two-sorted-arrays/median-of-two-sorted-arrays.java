class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i=0, j=0;
        if((m+n) == 1) {
            return m>0? nums1[0]:nums2[0];
        }
        int len = (int) Math.ceil(m+n)/2;
        Deque<Integer> queue = new LinkedList<>();

        while((i+j)<=len) {
            if(i==m) {
                queue.addFirst(nums2[j]);
                j++;
            } else if(j == n) {
                queue.addFirst(nums1[i]);
                i++;
            } else if(nums1[i] < nums2[j]) {
                queue.addFirst(nums1[i]);
                i++;
            } else {
                queue.addFirst(nums2[j]);
                j++;
            }
            if(queue.size() > 2) {
                queue.removeLast();
            }
        }

        int sum = 0;
        if(((m+n) & 1) == 0) {
            while(!queue.isEmpty()) {
                sum += queue.removeFirst();
            }
            return (double) sum/2;
        } else {
            sum += queue.removeFirst();
        }

        return sum;        
    }
}