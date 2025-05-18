class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        char[] sArr = s.toCharArray();
        List<Integer> res = new ArrayList<>();

        for(char ch: p.toCharArray()) {
            pCount[ch-'a']++;
        }

        for(int l=0, r=0; l<=r && r<sArr.length; r++) {
            int ind = sArr[r] - 'a';
            sCount[ind]++;

            if(sCount[ind] > pCount[ind]) {

                while(l<r && sArr[l] != sArr[r]) {
                    sCount[sArr[l++]-'a']--;
                }
                sCount[sArr[l++] - 'a']--;

            } 
            
            if((r-l+1) == p.length()) {
                res.add(l);
            }
        }


        return res;
    }
}