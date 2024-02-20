class Encrypter {
    
    // private HashMap<Character, String> mapping = new HashMap<>();
    Map<String, Integer> count;
    String[] k = new String[26];

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i=0; i<keys.length; i++) {
            // mapping.put(keys[i], values[i]);
            k[keys[i] - 'a'] = values[i];
        }
        
        count = new HashMap<>();
        for (String w : dictionary) {
            String e = encrypt(w);
            count.put(e, count.getOrDefault(e, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        char[] wordArr = word1.toCharArray();
        for(char i: word1.toCharArray()) {
            res.append(k[i - 'a'] == null? "#": k[i - 'a']);
        }
        return res.toString();
    }
    
    public int decrypt(String word2) {
        return count.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */