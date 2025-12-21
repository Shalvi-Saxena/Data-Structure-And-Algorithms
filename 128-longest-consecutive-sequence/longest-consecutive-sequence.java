class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++) {
            queue.add(nums[i]);
        }

        int max = 0;
        while(!queue.isEmpty()) {
            int temp = 1;
            int i = queue.poll();

            while(!queue.isEmpty()) {
                if (Integer.compare(queue.peek(), i+1) == 0) {
                    temp++;
                    i = queue.poll();
                } else if(Integer.compare(queue.peek(), i) == 0) {
                    queue.poll();
                } else {
                    break;
                }
            }

            max = Math.max(temp, max);
        }

        return max;
    }
}