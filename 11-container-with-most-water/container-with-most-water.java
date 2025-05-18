class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0, l=0, r=height.length-1;

        while(l<r) {
            int water = (r-l)*Math.min(height[l], height[r]);
            maxWater = Math.max(water, maxWater);

            if(height[l]< height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }
}