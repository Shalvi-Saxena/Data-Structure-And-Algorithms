class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE;
        HashSet<String> points = new HashSet<>();
        int area = 0;

        for(int[] rect: rectangles) {
            int x = rect[0], y = rect[1];
            int a = rect[2], b = rect[3];

            area += ((a-x)*(b-y));

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxA = Math.max(maxA, a);
            maxB = Math.max(maxB, b);

            String topLeft = getHash(x, b);
            String topRight = getHash(a, b);
            String bottomRight = getHash(a, y);
            String bottomLeft = getHash(x, y);

            checkSet(topLeft, points);
            checkSet(topRight, points);
            checkSet(bottomRight, points);
            checkSet(bottomLeft, points);
        }

        if(points.size() != 4)  return false;

        String topLeft = getHash(minX, maxB);
        String topRight = getHash(maxA, maxB);
        String bottomRight = getHash(maxA, minY);
        String bottomLeft = getHash(minX, minY);

        if(!points.contains(topLeft) || !points.contains(topRight)
         || !points.contains(bottomRight) || !points.contains(bottomLeft)) {
            return false;
         }

        int fullArea = (maxA - minX) * (maxB - minY);

        return area == fullArea;        
    }

    private void checkSet(String key, HashSet<String> set) {
        if(set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }

    private String getHash(int x, int y) {
        return x+":"+y;
    }
}