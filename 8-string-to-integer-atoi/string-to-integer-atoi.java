class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int i=0, sign=1, n=s.length();
        long num=0;
        char[] arr = s.toCharArray();

        while(i<n && arr[i] == ' ') {
            i++;
        }

        if(i<n && arr[i] == '+') {
            i++;
        } else if(i<n && arr[i] == '-') {
            sign = -1;
            i++;
        }

        for(; i<n && arr[i] >= '0' && arr[i] <= '9' && num <= Integer.MAX_VALUE; i++) {
            num*=10;
            num+= arr[i]-'0';
        }

        if(num > Integer.MAX_VALUE) {
            return sign>0? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }

        return (int)num*sign;
    }
}