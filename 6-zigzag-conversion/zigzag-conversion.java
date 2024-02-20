class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1 || s.length() ==1) return s;
        
        String res = "";
        int gap = (numRows-1)*2, j=0;
        int gap2=gap;
        
        for(int i=0; i<s.length() && i<numRows; i++) {
            res=res+s.charAt(i);
            // System.out.println(res+"  "+i+"  "+gap2+"  "+j);
            
            for(int k=i; k<s.length() && gap2>=0 && j<=gap; k+=(gap2+j)) {
                
                if(gap2>0 && (k+gap2)< s.length()) {
                    res=res+s.charAt(k+gap2);
                    // k+=gap2;
                }
                if(j>0 && (k+gap2+j)< s.length()) {
                    res=res+s.charAt(k+gap2+j);
                    // k+=j;
                }
             }
            gap2-=2;
            j+=2;
        }
        return res;
    }
}