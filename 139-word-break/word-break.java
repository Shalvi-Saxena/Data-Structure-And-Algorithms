class Solution {
    class Trie {
        Trie[] level;
        boolean isEOW;

        Trie() {
            level = new Trie[26];
            isEOW = false;
        }
    }

    public void insertWord(char[] str, Trie root) {
        Trie curr = root;
        for(char ch: str) {
            if(curr.level[ch-'a'] == null) {
                curr.level[ch-'a'] = new Trie();
            }
            curr = curr.level[ch-'a'];
        }
        curr.isEOW = true;
    }

    public boolean searchWord(char[] str, Trie root, int i, Boolean[] dp) {
        if(i==str.length) {
            return true;
        }
        if(dp[i] != null) {
            return dp[i];
        }
        Trie curr = root;
        for(int j=i; j<str.length; j++) {
            int ind = str[j]-'a';
            if(curr.level[ind] == null) {
                break;
            }
            curr = curr.level[ind];
            if(curr.isEOW && searchWord(str, root, j+1, dp)) {
                return dp[j] = true;
            }
        }
        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for(String str: wordDict) {
            insertWord(str.toCharArray(), root);
        }
        return searchWord(s.toCharArray(), root, 0, new Boolean[s.length()]);
    }
}