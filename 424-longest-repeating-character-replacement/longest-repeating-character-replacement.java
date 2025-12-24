class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int max = 0, len = 0;

        for(int i=0, j=0; i<arr.length; i++) {
            int idx = arr[i]-'A';
            freq[idx]++;
            max = Math.max(max, freq[idx]);

            if((i-j+1 - max) > k) {
                freq[arr[j]-'A']--;
                j++;
            }
            len = Math.max(len, i-j+1);
        }

        return len;
    }
}