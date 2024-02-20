class Solution {
    public int lengthOfLongestSubstring(String s) {
        String res = "";
        int len = 0;
        for(int i=0; i<s.length(); i++) {
            
            
            if(res.indexOf(s.charAt(i)) >= 0) {
                
                // System.out.println(res+ "  " + i + "  " + len + "  " + res.substring(res.indexOf(s.charAt(i))+1, res.length())  );
                
                len = Math.max(res.length(), len);
                
                if(res.indexOf(s.charAt(i)) == res.length()-1) {
                    res = "";
                } else {
                    res = res.substring(res.indexOf(s.charAt(i))+1, res.length());
                }
                res = res+s.charAt(i);
                
            } else {
                res = res+s.charAt(i);
            }
        }
        // System.out.println(res);
        return Math.max(res.length(), len);
    }
}