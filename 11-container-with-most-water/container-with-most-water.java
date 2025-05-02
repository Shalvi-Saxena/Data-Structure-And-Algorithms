class Solution {
    public int maxArea(int[] height) {
        int maxArea=0, i=0, j=height.length-1;

        while(i<j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight*(j-i);
            maxArea = Math.max(area, maxArea);
            while(i<height.length && height[i] <= minHeight)   i++;
            while(j>=0 && height[j] <= minHeight)   j--;
        }

        return maxArea;
    }
}