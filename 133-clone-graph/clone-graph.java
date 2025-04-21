/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        return DFS(node, new HashMap<Node, Node>());
    }

    public Node DFS(Node curr, HashMap<Node, Node> isVisited) {
        Node new_curr = new Node(curr.val);
        if(curr.neighbors.isEmpty()) {
            return new_curr;
        }
        isVisited.put(curr, new_curr);
        List<Node> new_neighbors = new_curr.neighbors;

        for(Node item: curr.neighbors) {
            if(isVisited.containsKey(item)) {
                new_neighbors.add(isVisited.get(item));
            } else {
                Node new_item = DFS(item, isVisited);
                new_neighbors.add(new_item);
            }
        }

        return new_curr;
    }
}