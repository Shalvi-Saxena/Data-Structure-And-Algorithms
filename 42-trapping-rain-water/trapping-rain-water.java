class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int lMax = 0, rMax = 0, water = 0, l = 0, r = n-1;

        while(l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if(lMax < rMax) {
                water += lMax - height[l++];
            } else {
                water += rMax - height[r--];
            }
        }
        return water;
    }
}