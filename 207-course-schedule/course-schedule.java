class Solution {
    public boolean isCycle(HashMap<Integer, List<Integer>> map, int i, boolean[] currVisited, boolean[] isVisited) {
        if(currVisited[i])  return true;
        if(isVisited[i] || map.get(i).size() == 0) {
            return false;
        }

        currVisited[i] = true;
        for(int j: map.get(i)) {
            if(isCycle(map, j, Arrays.copyOf(currVisited, currVisited.length), isVisited)) {
                return true;
            }
            isVisited[j] = true;
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] course: prerequisites) {
            map.get(course[0]).add(course[1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(isVisited[i])    continue;
            if(isCycle(map, i, new boolean[numCourses], isVisited)) {
                return false;
            }
            isVisited[i] = true;
        }

        return true;
    }
}