class Solution {
    public boolean isCycle(HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> isVisited, Integer course, boolean[] noCycleForCourse) {
        if(isVisited.contains(course)) {
            return true;
        }
        System.out.println("course. "+course);
        isVisited.add(course);
        if(!graph.containsKey(course) || noCycleForCourse[course]) {
            return false;
        }
        for(Integer i: graph.get(course)) {
            if(isCycle(graph, new ArrayList<Integer>(isVisited), i, noCycleForCourse)) {
                return true;
            }
            noCycleForCourse[i] = true;
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] course: prerequisites) {
            ArrayList<Integer> edges = graph.getOrDefault(course[0], new ArrayList<Integer>());
            edges.add(course[1]);
            graph.put(course[0], edges);
        }
        boolean[] noCycleForCourse = new boolean[numCourses+1]; 
        for(Integer course: graph.keySet()) {
            for(Integer i: graph.get(course)) {
                if(!noCycleForCourse[i] && isCycle(graph, new ArrayList<Integer>(), i, noCycleForCourse)){
                    System.out.println("course. "+course+". i  "+i);
                    return false;
                }
                noCycleForCourse[i] = true;
            }
                noCycleForCourse[course] = true;
        }
        return true;
    }
}