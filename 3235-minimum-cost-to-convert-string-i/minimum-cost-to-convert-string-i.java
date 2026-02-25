class Solution {
    class Node {
        char ch;
        long cost;
        Node(char ch, long cost) {
            this.ch = ch;
            this.cost = cost;
        }
    }
    HashMap<Character, List<Node>> graph = new HashMap<>();
    HashMap<Character, long[]> minCost = new HashMap<>();

    private long BFS(char s, char t) {
        if(minCost.containsKey(s)) {
            return minCost.get(s)[t-'a'];
        }

        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(s, 0));
        long[] min = new long[26];

        Arrays.fill(min, Long.MAX_VALUE);
        min[s-'a'] = 0;

        while(!q.isEmpty()) {
            Node curr = q.poll();

            for(Node n: graph.getOrDefault(curr.ch, new ArrayList<>())) {
                long currCost = curr.cost+n.cost;
                if(min[n.ch - 'a'] > currCost) {
                    min[n.ch - 'a'] = currCost;
                    q.add(new Node(n.ch, currCost));
                }
            }
        }

        minCost.put(s, min);
        return min[t-'a'];
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        for(int i=0; i<original.length; i++) {
            graph.putIfAbsent(original[i], new ArrayList<>());
            graph.get(original[i]).add(new Node(changed[i], cost[i]));
        }

        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        long tCost = 0;

        for(int i=0; i<src.length; i++) {
            
            if(src[i] == tar[i])    continue;

            if(!graph.containsKey(src[i])) {
                return -1;
            }
            long currCost = BFS(src[i], tar[i]);
            if(currCost == Long.MAX_VALUE) {
                return -1;
            }
            tCost += currCost;
        }
        
        return tCost;
    }
}