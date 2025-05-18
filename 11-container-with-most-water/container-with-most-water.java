class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0, l=0, r=height.length-1;

        while(l<r) {
            int minHeight = Math.min(height[l], height[r]);
            int water = (r-l)*minHeight;
            maxWater = Math.max(water, maxWater);

            while(l<r && height[l]<= minHeight) {
                l++;
            } 
            while(l<r && height[r]<= minHeight) {
                r--;
            }
        }

        return maxWater;
    }
}