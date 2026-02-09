class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char ch: s1.toCharArray()) {
            arr1[ch-'a']++;
        }

        char[] str = s2.toCharArray();

        for(int left=0, i=0; i<str.length; i++) {
            int ind = str[i]-'a';
            arr2[ind]++;

            while(arr2[ind] > arr1[ind]) {
                int leftInd = str[left++]-'a';
                arr2[leftInd]--;
            }

            if((i-left+1) == s1.length()) {
                return true;
            }
        }

        return false;
    }
}