class TrieNode {
    TrieNode[] node;
    boolean isEOW;
    TrieNode() {
        node = new TrieNode[26];
        isEOW = false;
    }
}

class WordDictionary {
    TrieNode dict;

    public WordDictionary() {
        dict = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode root = dict;
        for(char ch: word.toCharArray()) {
            int i = ch-'a';
            if(root.node[i] == null) {
                root.node[i] = new TrieNode();
            }
            root = root.node[i];
        }
        root.isEOW = true;
    }
    
    public boolean search(String word) {
        List<TrieNode> bfs = new LinkedList<>();
        bfs.add(dict);

        for(char ch: word.toCharArray()) {
            
            if(bfs.isEmpty()) {
                return false;
            }
            
            int s = bfs.size();
            int item = ch-'a';

            for(int i=0; i<s && !bfs.isEmpty(); i++) {
                TrieNode root = bfs.removeFirst();
                if(ch == '.') {
                    for(int j=0; j<26; j++) {
                        if(root.node[j] != null) {
                            bfs.add(root.node[j]);
                        }
                    }
                } else if(root.node[item] != null) {
                    bfs.add(root.node[item]);
                }
            }
        }

        while(!bfs.isEmpty()) {
            if(bfs.removeFirst().isEOW) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */