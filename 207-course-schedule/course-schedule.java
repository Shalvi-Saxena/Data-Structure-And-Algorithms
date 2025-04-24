class Solution {
    public boolean isCycle(List<List<Integer>> graph, boolean[] isVisited, int course, boolean[] courseStack) {
        isVisited[course] = true;
        courseStack[course] = true;
        
        for(Integer i: graph.get(course)) {
            if(courseStack[i]) {
                return true;
            }
            if(!isVisited[i]) {
                if(isCycle(graph, isVisited, i, courseStack)) {
                    return true;
                }
            }
            isVisited[i] = true;
        }
        courseStack[course] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] course: prerequisites) {
            graph.get(course[0]).add(course[1]);
        }
        boolean[] isVisited = new boolean[numCourses];
        boolean[] courseStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!isVisited[i]) {
                if(isCycle(graph, isVisited, i, courseStack)) {
                    return false;
                }
            }
            isVisited[i] = true;
        }
        return true;
    }
}