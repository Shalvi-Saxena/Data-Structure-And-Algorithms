class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int num: asteroids) {
            if(st.isEmpty() || num >= 0) {
                st.push(num);
            } else {
                
                while(!st.isEmpty() && num != 0 && st.peek() > 0) {
                    int diff = st.peek() + num;
                    if (diff < 0) {
                        st.pop();
                    } else if (diff > 0) {
                        num = 0;
                    } else {
                        st.pop();
                        num = 0;
                    }
                }

                if(num != 0) {
                    st.push(num);
                }

            }
        }

        int[] list = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--) {
            list[i] = st.pop();
        }

        return list;
    }
}