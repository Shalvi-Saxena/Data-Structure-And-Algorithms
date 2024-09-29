class Solution {
    public boolean checkRecord(String s) {
        int nA = 0, nL = 0;
        for(Character item: s.toCharArray()) {
            switch(item) {
                case 'L':
                    nL += 1;
                    if(nL >= 3)
                        return false;
                    break;
                case 'A':
                    nA += 1;
                    if(nA >= 2)
                        return false;
                    nL = 0;
                    break;
                default:
                    nL = 0;                
            }
        }
        return !(nA >= 2 || nL >= 3);    
    }
}