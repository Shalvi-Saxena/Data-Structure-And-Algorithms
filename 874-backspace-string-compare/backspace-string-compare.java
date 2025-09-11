class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = Math.max(sArr.length, tArr.length);
        Stack<Character> sSt = new Stack<>();
        Stack<Character> tSt = new Stack<>();
        
        for(int i=0; i<n; i++) {
            if(i<sArr.length) {
                if(sArr[i] == '#') {
                    if(!sSt.isEmpty())   sSt.pop();
                } else {
                    sSt.push(sArr[i]);
                }
            }
            if(i<tArr.length) {
                if(tArr[i] == '#') {
                    if(!tSt.isEmpty())  tSt.pop();
                } else {
                    tSt.push(tArr[i]);
                }
            }
        }

        if(sSt.size() != tSt.size()) {
            return false;
        }

        while(!sSt.isEmpty()) {
            if(sSt.pop() != tSt.pop()) {
                return false;
            }
        }

        return true;
    }
}