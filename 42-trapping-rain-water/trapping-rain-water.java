class Solution {
    public int trap(int[] height) {
        int n = height.length, lMax = height[0], water = 0;
        Stack<Integer> rMax = new Stack<>();
        rMax.push(height[n-1]);
        for(int i=n-2; i>0; i--) {
            rMax.push(Math.max(height[i], rMax.peek()));
        }

        for(int i=1; i<n-1; i++) {
            lMax = Math.max(lMax, height[i]);
            water += Math.min(lMax, rMax.pop())-height[i];
        }
        return water;
    }
}