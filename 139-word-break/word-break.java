class Solution {
    class Trie{
        Trie[] level;
        boolean isEOW;
        Trie() {
            level = new Trie[26];
            isEOW = false;
        }
    }

    public void add(char[] str, Trie root) {
        Trie curr = root;
        for(int i=0; i<str.length; i++) {
            int index = str[i]-'a';
            if(curr.level[index] == null) {
                curr.level[index] = new Trie();
            }
            curr = curr.level[index];
        }
        curr.isEOW = true;
    }

    public boolean search(char[] str, Trie root, int i, Boolean[] dp) {
        if(i==str.length) {
            return true;
        }
        if(dp[i] != null) {
            return dp[i];
        }
        Trie curr = root;
        for (int j = i; j < str.length; j++) {
            int index = str[j] - 'a';
            if (curr.level[index] == null) break;
            curr = curr.level[index];
            if (curr.isEOW && search(str, root, j+1, dp)) {
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String str: wordDict) {
            add(str.toCharArray(), trie);
        }
        char[] str = s.toCharArray();
        return search(str, trie, 0, new Boolean[str.length]);
    }
}