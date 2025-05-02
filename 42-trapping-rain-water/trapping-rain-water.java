class Solution {
    public int trap(int[] height) {
        Stack<Integer> rMax = new Stack<>();
        rMax.push(height[height.length -1 ]);
        for(int i=height.length-2; i>0; i--) {
            if(height[i] > rMax.peek()) {
                rMax.push(height[i]);
            } else {
                rMax.push(rMax.peek());
            }
        }
        int water = 0, lMax = height[0];
        for(int i=1; i<height.length-1; i++) {
            int min = Math.min(lMax, rMax.pop());
            water += Math.max(0, (min-height[i]));
            lMax = Math.max(lMax, height[i]);
        }
        return water;
    }
}