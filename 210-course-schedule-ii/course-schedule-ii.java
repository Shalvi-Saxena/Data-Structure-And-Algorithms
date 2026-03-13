class Solution {
    List<Integer> res = new ArrayList<>();

    private boolean isPossible(List<List<Integer>> course, int n, int i, boolean[] isVisited, boolean[] isCycle) {
        if(i>=n || isCycle[i])    return false;
        if(isVisited[i])    return true;

        isCycle[i] = true;

        for(int item: course.get(i)) {
            if(!isPossible(course, n, item, isVisited, isCycle)) {
                return false;
            }
        }

        isVisited[i] = true;
        res.add(i);
        isCycle[i] = false;

        return true;
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> course = new ArrayList<>();

        for(int i=0; i<n; i++) {
            course.add(new ArrayList<>());
        }

        for(int[] c: prerequisites) {
            course.get(c[0]).add(c[1]);
        }

        boolean[] isVisited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!isPossible(course, n, i, isVisited, new boolean[n])) {
                return new int[0];
            }
        }

        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}