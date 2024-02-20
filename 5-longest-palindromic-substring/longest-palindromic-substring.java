class Solution {
    public String longestPalindrome(String s) {
        Pair<Integer, Integer> res = new Pair(0, 0);
        int lenRes = 1;
        
        for(int i=0; i<s.length(); i++) {
            Pair<Integer, Integer> even = expand(s, i, i+1);
            int lenEven = even.getValue()-even.getKey()+1;
            
            Pair<Integer, Integer> odd = expand(s, i, i);
            int lenOdd = odd.getValue()-odd.getKey()+1;
            
            if(lenEven > lenOdd && lenEven > lenRes) {
                res = even;
                lenRes = lenEven;
            } else if(lenEven < lenOdd && lenOdd > lenRes) {
                res = odd;
                lenRes = lenOdd;
            }
            // System.out.println(i+"  "+even+"  "+lenEven+"  "+odd+"  "+lenOdd+"  "+res+"  "+lenRes);
            
        }
        return s.substring(res.getKey(), res.getValue()+1);
    }
    
    public Pair expand(String s, int left, int right) {
        int l=left, r=right;
        
        if(r>=s.length() || s.charAt(l) != s.charAt(r)) return new Pair(l, l);
        
        while(l>0 && r<(s.length()-1) ) {
            if(s.charAt(l-1) == s.charAt(r+1)) {
                l--;
                r++;
            } else break;
        }
        
        return new Pair<Integer, Integer>(l, r);
    }
}