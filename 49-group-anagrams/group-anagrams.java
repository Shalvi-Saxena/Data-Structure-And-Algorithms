class Solution {
    public String createHashKey(String str) {
        int[] count = new int[26];
        for(char ch: str.toCharArray()) {
            count[ch-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(count[i] > 0) {
                key.append((char)(i+'a'));
                key.append(count[i]);
            }
        }
        return key.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            String key = createHashKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
}