class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        char[] pArr = p.toCharArray(), sArr = s.toCharArray();
        for(char ch: pArr) {
            count[ch-'a']++;
        }
        List<Integer> anagrams = new ArrayList<>();
        int[] charCount = new int[26];
        
        for(int i=0, j=0; i<sArr.length && j<=i; i++) {
            int index = sArr[i]-'a';
            charCount[index]++;
            if(charCount[index] > count[index]) {
                while(j<i && sArr[j] != sArr[i]) {
                    charCount[sArr[j++]-'a']--;
                }
                charCount[sArr[j++]-'a']--;
            } 
            if(i-j == pArr.length-1) {
                anagrams.add(j);
            }
        }

        return anagrams;
    }
}