class Solution {
    public int findLUSlength(String[] strs) {
        Set<String> set = new HashSet<String>();
        Set<String> dups = new HashSet<>();

        Arrays.sort(strs, (a,b) -> b.length() - a.length());
        
        for(String str: strs) {
            if(set.contains(str)) {
                dups.add(str);
            } else {
                set.add(str);
            }
        }
        
        for(String str: strs) {
            if(dups.contains(str)) {
                continue;
            }
            boolean flag = false;
            for(String strTemp: strs) {
                    if(strTemp.equals(str)) break;
                    flag = flag || checkIfSubstring(str, strTemp);
            }
            if(!flag) return str.length();
            
        }
        return -1;
    }

    boolean checkIfSubstring(String str1, String str2) {
        int i=0,j=0;
        for(i=0, j=0; i<str1.length() && j<str2.length(); j++) {
            if(str1.charAt(i) == str2.charAt(j))
                i++;
        }
        return i==str1.length();
    }
}