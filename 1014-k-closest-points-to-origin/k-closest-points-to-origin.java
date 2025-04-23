class Solution {
    public double getDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2)+ Math.pow(point[1], 2));
    }
    public int[][] kClosest(int[][] points, int k) {
        TreeMap<Double, ArrayList<Integer>> dist = new TreeMap<>();
        int i=0;

        for(int[] point: points) {
            ArrayList<Integer> arr = dist.getOrDefault(getDistance(point), new ArrayList<Integer>());
            arr.add(i);
            dist.put(getDistance(point), arr);
            i++;
        }

        List<int[]> res = new ArrayList<>();

        i=0;
        for(Double key: dist.keySet()) {
            for(Integer j: dist.get(key)) {
                res.add(points[j]);
                i++;
            }
            if(i==k)    break;
        }

        return res.toArray(new int[res.size()][]);
    }
}