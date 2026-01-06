class Solution {
    public boolean isCycle(int i, List<Integer> seq, 
        HashMap<Integer, List<Integer>> map, List<Integer> set) {
        if(seq.contains(i))     return false;
        if(set.contains(i))     return true;
        set.add(i);

        for(Integer j: map.get(i)) {
            if(isCycle(j, seq, map, set))   return true;
        }
        set.remove(new Integer(i));
        seq.add(i);
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] course: prerequisites) {
            map.get(course[0]).add(course[1]);
        }

        List<Integer> seq = new ArrayList<>();

        for (Integer i : map.keySet()) {
            if(!seq.contains(i) && isCycle(i, seq, map, new ArrayList<>())) {
                return new int[0];
            }
        }

        int i=0;
        int[] res = new int[numCourses];
        for(int j: seq) {
            res[i++] = j;
        }

        for(int j=0; j<numCourses; j++) {
            if(!seq.contains(j)) {
                res[i++] = j;
            }
        }

        return res;
    }
}