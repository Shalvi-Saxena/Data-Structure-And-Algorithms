class Solution {
    int i;
    private String decode(char[] s) {
        StringBuilder res = new StringBuilder();
        int num = 0;

        while (i < s.length) {
            if(Character.isDigit(s[i])) {
                num = (num*10) + (s[i]-'0');
                i++;
            } else if(s[i] == '[') {
                i++;
                String subStr = decode(s);
                for(int j = 0; j<num; j++) {
                    res.append(subStr);
                }
                num = 0;
            } else if(s[i] == ']') {
                i++;
                return res.toString();
            } else {
                res.append(s[i]);
                i++;
            }
        }
        return res.toString();
    }

    public String decodeString(String s) {
        i=0;
        return decode(s.toCharArray());
    }
}