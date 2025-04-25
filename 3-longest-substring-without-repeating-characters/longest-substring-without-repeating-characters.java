class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, i=0, j=0;

        for(i=0, j=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                while(s.charAt(j) != s.charAt(i)){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, set.size());
            // System.out.println("maxLength. "+maxLength+". i = "+i+". j = "+j+" set = "+set);
        }

        return maxLength;
    }
}