class Trie {

    class Node {
        char val;
        boolean end;
        Node[] nextNode;
        
        private Node(char val, Node[] nextNode) {
            this.val = val;
            this.end = false;
            this.nextNode = nextNode;
        }
    }
    Node root;

    public Trie() {
        root = new Node('0', new Node[26]);
    }
    
    public void insert(String word) {
        Node tempRoot = root;
        for(char item: word.toCharArray()) {
            if(tempRoot.nextNode[item-'a'] != null) {
                tempRoot = tempRoot.nextNode[item-'a'];
            } else {
                tempRoot.nextNode[item-'a'] = new Node(item, new Node[26]);
                tempRoot = tempRoot.nextNode[item-'a'];
            }
        }
        tempRoot.end = true;
    }
    
    public boolean search(String word) {
        Node tempRoot = root;
        for(char item: word.toCharArray()) {
            if(tempRoot.nextNode[item-'a'] == null) {
                return false;
            }
            tempRoot = tempRoot.nextNode[item-'a'];
        }
        return tempRoot.end;
    }
    
    public boolean startsWith(String prefix) {
        Node tempRoot = root;
        for(char item: prefix.toCharArray()) {
            if(tempRoot.nextNode[item-'a'] == null) {
                return false;
            }
            tempRoot = tempRoot.nextNode[item-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */