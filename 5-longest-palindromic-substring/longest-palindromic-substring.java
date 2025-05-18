class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1 ) {
            return s;
        }
        int maxSize = 1, start=0, n = s.length();
        char[] sArr = s.toCharArray();

        for(int i=0; i<s.length()-1; i++) {
            for(int l=i-1, r=i+1; l>=0 && r<s.length() && sArr[l] == sArr[r]; l--, r++) {
                if(r-l+1 > maxSize) {
                    maxSize = r-l+1;
                    start = l;
                }
            }

            if(sArr[i] == sArr[i+1]) {
                for(int l=i, r=i+1; l>=0 && r<s.length() && sArr[l] == sArr[r]; l--, r++) {
                    if(r-l+1 > maxSize) {
                        maxSize = r-l+1;
                        start = l;
                    }
                }
            }
        }

        return s.substring(start, start+maxSize);
    }
}