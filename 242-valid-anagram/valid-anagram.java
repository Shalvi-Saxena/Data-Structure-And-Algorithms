import java.io.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1 );
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) - 1 );
        }
        // System.out.print(hm.keySet());
        // System.out.print(hm.values());
        for(int i: hm.values()) {
            if(i!=0) {
                return false;
            }
        }
        return true;
    }
}