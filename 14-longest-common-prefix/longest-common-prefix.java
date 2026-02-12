class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1)
            return strs[0];

        char[] str = new char[strs[0].length()];
        int i=0, maxLen = str.length;

        for(char ch: strs[0].toCharArray()) {
            str[i++] = ch;
        }

        for(i=1; i<strs.length; i++) {
            char[] tempStr = strs[i].toCharArray();
            int j=0, n = Math.min(tempStr.length, maxLen);
            for(; j<n; j++) {
                if(str[j] != tempStr[j])
                    break;
            }
            maxLen = j;
        }

        String res = "";
        for(i=0; i<maxLen; i++) {
            res = res+str[i];
        }

        return res;
    }
}