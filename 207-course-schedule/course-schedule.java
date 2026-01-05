class Solution {
    public boolean isCycle(int i, boolean[] isVisited, 
            HashMap<Integer, List<Integer>> map, HashSet<Integer> set) {
        if(set.contains(i)) {
            return true;
        }
        if(isVisited[i] || !map.containsKey(i)) {
            return false;
        }
        set.add(i);
        for(Integer j: map.get(i)) {
            if(isCycle(j, isVisited, map, set)) {
                return true;
            }
        }
        isVisited[i] = true;
        set.remove(i);
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] course: prerequisites) {
            if (!map.containsKey(course[0])) {
                map.put(course[0], new ArrayList<>());
            }
            map.get(course[0]).add(course[1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!isVisited[i] 
                && isCycle(i, isVisited, map, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }
}