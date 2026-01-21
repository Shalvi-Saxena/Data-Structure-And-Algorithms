class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word; 
    }
    int m, n;

    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            Trie curr = root;
            for(char ch: word.toCharArray()) {
                if(curr.next[ch-'a'] == null)
                    curr.next[ch-'a'] = new Trie();
                curr = curr.next[ch-'a'];
            }
            curr.word = word;
        }

        return root;
    }

    public void dfs(char[][] board, int i, int j, Trie root, List<String> res) {
        if (i<0 || j<0 || i==m || j==n)  return;

        char ch = board[i][j];
        if(ch == '#' || root.next[ch-'a'] == null)  return;

        root = root.next[ch-'a'];
        if(root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';

        dfs(board, i-1, j, root, res);
        dfs(board, i+1, j, root, res);
        dfs(board, i, j-1, root, res);
        dfs(board, i, j+1, root, res);

        board[i][j] = ch;
        return;
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Trie root = buildTrie(words);
        List<String> res = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
}