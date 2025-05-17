class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }

        int n = beginWord.length(), res = 1;
        HashMap<String, List<String>> dict = new HashMap<>();

        for(String word: wordList) {
            for(int i=0; i<n; i++) {
                String key = word.substring(0, i)+"*"+word.substring(i+1, n);
                dict.putIfAbsent(key, new ArrayList<>());
                dict.get(key).add(word);
            }
        }

        Set<String> isVisited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        isVisited.add(beginWord);
        q.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String word = q.poll();
                if(word.equals(endWord)) {
                    return res;
                }
                for(int i=0; i<n; i++) {
                    String key = word.substring(0, i)+"*"+word.substring(i+1, n);
                    for(String neiWord: dict.getOrDefault(key, new ArrayList<>())) {
                        if(!isVisited.contains(neiWord)) {
                            isVisited.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }
            res++;
        }
        
        return 0;
    }
}