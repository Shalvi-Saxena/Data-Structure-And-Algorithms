class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int num: nums2) {
            while( !st.isEmpty() && num > st.peek() ) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        int[] res = new int[nums1.length];
        int i=0;

        for(int num: nums1) {
            res[i++] = map.getOrDefault(num, -1);
        }

        return res;
    }
}