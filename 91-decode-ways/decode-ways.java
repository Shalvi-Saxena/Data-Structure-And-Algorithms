class Solution {
    int n;
    int[] memo;
    public int decodeWays(char[] str, int i) {
        if(i == n)  return 1;
        if(str[i] == '0')   return 0;
        if(memo[i] != 0) return memo[i];

        int ways = decodeWays(str, i+1);
        if(i<n-1) {
            int num = (str[i] - '0') * 10 + (str[i + 1] - '0');
            if (num <= 26) {
                ways += decodeWays(str, i + 2);
            }
        }

        memo[i] = ways; 

        return ways;
    }
    public int numDecodings(String s) {
        n = s.length();
        memo = new int[n];
        return decodeWays(s.toCharArray(), 0);
    }
}