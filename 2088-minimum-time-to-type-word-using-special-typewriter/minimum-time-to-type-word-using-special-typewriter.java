class Solution {
    public int getCWDist(char a, char b) {
        if(a>b) {
            b += 26;
        }
        return Math.abs(b-a);
    }
    
    public int getACWDist(char a, char b) {
        
        return 26-getCWDist(a, b);
    }
    
    public int minTimeToType(String word) {
        char currLetter = 'a';
        int time = 0;
        for(int i=0; i<word.length(); i++) {
            time += Math.min(getACWDist(currLetter, word.charAt(i)), getCWDist(currLetter, word.charAt(i)));
            // System.out.println("currL "+currLetter+"  word "+ word.charAt(i)+"  getCWDist(currLetter, word.charAt(i)) "+getCWDist(currLetter, word.charAt(i))+ "  getACWDist(currLetter, word.charAt(i)) "+getACWDist(currLetter, word.charAt(i)));
            currLetter = word.charAt(i);
            time++;
        }
        
        return time;        
    }
}