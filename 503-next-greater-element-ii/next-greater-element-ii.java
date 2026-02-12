class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i=nums.length-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() < nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
            max = Math.max(max, nums[i]);
        }

        int[] res = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty()? -1: st.peek();
            st.push(nums[i]);
        }

        return res;
    }
}