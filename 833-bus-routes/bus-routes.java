class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(busId);
            }
        }

        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            return -1;
        }

        Deque<Integer> queue = new LinkedList<>();
        Set<Integer> busesTaken = new HashSet<>();
        Set<Integer> stopsVisited = new HashSet<>();
        int res = 0;

        queue.offer(source);

        while (!queue.isEmpty()) {
            res++;
            int stopsToProcess = queue.size();

            for (int i = 0; i < stopsToProcess; i++) {
                int currentStop = queue.poll();

                for (int busId : stopToBuses.getOrDefault(currentStop, new ArrayList<>())) {
                    if (busesTaken.contains(busId)) {
                        continue;
                    }

                    busesTaken.add(busId);

                    for (int nextStop : routes[busId]) {
                        if (stopsVisited.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return res;
                        }

                        queue.offer(nextStop);
                        stopsVisited.add(nextStop);
                    }
                }
            }
        }

        return -1;
    }
}