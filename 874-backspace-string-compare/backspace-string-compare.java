class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Stack<Character> sSt = new Stack<>();
        Stack<Character> tSt = new Stack<>();
        
        for(char ch: sArr) {
            if(ch == '#') {
                if(!sSt.isEmpty())  sSt.pop();
            } else {
                sSt.push(ch);
            }
        }

        for(char ch: tArr) {
            if(ch == '#') {
                if(!tSt.isEmpty())  tSt.pop();
            } else {
                tSt.push(ch);
            }
        }

        while(!sSt.isEmpty() && !tSt.isEmpty()) {
            if(sSt.pop() != tSt.pop())    return false;
        }

        return sSt.isEmpty() && tSt.isEmpty();
    }
}