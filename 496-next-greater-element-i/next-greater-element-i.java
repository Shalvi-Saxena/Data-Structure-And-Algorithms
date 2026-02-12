class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n1 = nums1.length, n2 = nums2.length;

        for(int i=n1-1; i>=0; i--) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        
        for(int i=n2-1; i>=0; i--) {
            int key = nums2[i];
            while(!st.isEmpty() && st.peek()< key) {
                st.pop();
            }

            if(map.containsKey(key)) {
                res[map.get(key)] = st.isEmpty()? -1: st.peek();
            }

            st.push(key);
        }

        return res;
    }
}