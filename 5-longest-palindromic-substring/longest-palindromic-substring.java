class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)   return s;
        int start=0, maxLength=1;
        char[] str = s.toCharArray();
        for(int i=0; i<str.length-1; i++) {
            // Check for odd length
            int low = i-1, high = i+1;
            while(low >= 0 && high < str.length && str[low] == str[high]) {
                if(high-low+1 > maxLength) {
                    start = low;
                    maxLength = high-low+1;
                }
                low--;
                high++;
            }
            // Check for even length
            if(str[i] == str[i+1]) {
                low = i; high = i+1;
                while(low >= 0 && high < str.length && str[low] == str[high]) {
                    if(high-low+1 > maxLength) {
                        start = low;
                        maxLength = high-low+1;
                    }
                    low--;
                    high++;
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
}