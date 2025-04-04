class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0)+1);
        }

        for(int i=0; i<magazine.length(); i++) {
            map.computeIfPresent(magazine.charAt(i), (k, v) -> v-1);
        }

        for(Integer i: map.values()) {
            if(i>0)
                return false;
        }
        return true;
    }
}