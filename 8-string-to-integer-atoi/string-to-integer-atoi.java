class Solution {
    public int myAtoi(String s) {
        long result=0, maxValue = (long)Integer.MAX_VALUE+1;
        int i=0, conv=1;
        char[] str = s.toCharArray();
        while(i<str.length && str[i] == ' ') {
            i++;
        }
        if(i<str.length && str[i] == '-') {
            conv = -1;
            i++;
        } else if(i<str.length && str[i] == '+') {
            i++;
        }
        while(i<str.length && str[i] >= '0' && str[i] <= '9' && result <= maxValue) {
            result *= 10;
            result += str[i]-'0';
            i++;
        }

        result *= conv;

        if(result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if(result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) result;
    }
}