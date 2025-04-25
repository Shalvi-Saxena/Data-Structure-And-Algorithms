class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] set = new boolean[128];
        char[] sArr = s.toCharArray();
        int maxLength = 0, i=0, j=0;

        for(i=0, j=0; i<s.length(); i++) {
            if(set[sArr[i]]) {
                while(sArr[j] != sArr[i]){
                    set[sArr[j]] = false;
                    j++;
                }
                set[sArr[j]] = false;
                j++;
            }
            set[sArr[i]] = true;
            maxLength = Math.max(maxLength, i-j+1);
        }

        return maxLength;
    }
}