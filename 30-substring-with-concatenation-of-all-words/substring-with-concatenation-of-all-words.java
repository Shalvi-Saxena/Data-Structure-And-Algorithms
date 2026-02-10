class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> dict = new HashMap<>();
        for(String word: words) {
            dict.put(word, dict.getOrDefault(word, 0)+1);
        }

        List<Integer> res = new ArrayList<>();
        int l = words.length, wL = words[0].length();

        for(int i=0; i<wL; i++) {
            HashMap<String, Integer> win = new HashMap<>();
            int left = i, count = 0;

            for(int r =i; r+wL <= s.length(); r += wL) {
                String w = s.substring(r, r+wL);
                
                if(dict.containsKey(w)) {
                    win.put(w, win.getOrDefault(w, 0)+1);
                    count++;

                    while(win.get(w) > dict.get(w)) {
                        String lW = s.substring(left, left+wL);
                        left += wL;
                        win.put(lW, win.get(lW)-1);
                        count--;
                    }
                    if(count == words.length) {
                        res.add(left);
                    }
                } else {
                    win.clear();
                    count = 0;
                    left = r+wL;
                }
            }
        }
        return res;
    }
}