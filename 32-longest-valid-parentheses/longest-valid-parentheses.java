class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLength = 0;
        char[] str = s.toCharArray();

        for(int i=0; i<str.length; i++) {
            if(str[i] == '(') {
                st.push(i);
            } else {
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLength = Math.max(maxLength, i-st.peek());
                }
            }
        }

        return maxLength;
    }
}