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
            if(root.node[ch-'a'] == null) {
                root.node[ch-'a'] = new TrieNode();
            }
            root = root.node[ch-'a'];
        }
        root.isEOW = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, dict);
    }
    
    public boolean dfs(char[] word, int i, TrieNode root) {
        if(i == word.length) {
            return root == null? false: root.isEOW;
        }

        if(word[i] == '.') {
            for(int j=0; j<26; j++) {
                if(root.node[j] != null && dfs(word, i+1, root.node[j])) {
                    return true;
                }
            }
        } else if(root.node[word[i]-'a'] != null) {
            return dfs(word, i+1, root.node[word[i]-'a']);
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