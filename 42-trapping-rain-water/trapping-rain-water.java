class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int rMax = 0, lMax = 0, l=0, r=height.length-1, water=0;

        while(l<r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if(lMax<rMax) {
                water += lMax-height[l++];
            } else {
                water += rMax-height[r--];
            }
        }
        return water;
    }
}