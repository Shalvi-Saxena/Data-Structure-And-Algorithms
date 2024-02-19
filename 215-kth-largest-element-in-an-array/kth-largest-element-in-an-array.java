class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
        
        while(pq.size() > k) {
            pq.poll();
        }
        
        if(pq.size() == 0) return Integer.MIN_VALUE;
        
        return pq.peek();
        
    }
}