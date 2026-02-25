class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        int n = str.length, j=0;
        
        while(j<n && str[j].isBlank()) {
            j++;
        }
        
        StringBuffer res = new StringBuffer();

        for(int i=str.length-1; i>=j; i--) {
            
            if(str[i].isBlank())
                continue;
            
            res.append(str[i]);
            if(i > j) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}