class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxAr = 0;
        for(int i=0; i<heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()]>heights[i]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek()-1;
                maxAr = Math.max(maxAr, h*w);
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            maxAr = Math.max(maxAr, h*w);
        }

        return maxAr;
    }
}