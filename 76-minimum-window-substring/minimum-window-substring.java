class Solution {
    public String minWindow(String s, String t) {
        int[] arr1 = new int[255];
        int[] arr2 = new int[255];
        
        for(char ch: t.toCharArray()) {
            arr1[ch]++;
        }

        char[] str = s.toCharArray();
        int len = 0, minLen = Integer.MAX_VALUE, min = 0;

        for(int left=0, i=0; i<str.length; i++) {
            int ind = str[i];
            arr2[ind]++;

            if(arr2[ind] <= arr1[ind])  len++;

            while(len == t.length()) {
                if((i-left+1) < minLen) {
                    minLen = i-left+1;
                    min = left;
                }

                int leftInd = str[left++];
                if(arr2[leftInd] <= arr1[leftInd])  len--;
                arr2[leftInd]--;
            }
        }

        return minLen == Integer.MAX_VALUE? "": s.substring(min, min+minLen);
    }
}