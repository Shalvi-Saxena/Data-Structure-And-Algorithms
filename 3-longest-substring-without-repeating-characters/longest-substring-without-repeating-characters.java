class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] dict = new boolean[255];
        char[] arr = s.toCharArray();
        int max = 0;

        for(int left=0, i=0; i<arr.length; i++) {
            if(dict[arr[i]]) {
                while(dict[arr[i]]) {
                    dict[arr[left++]] = false;
                }
            }
            dict[arr[i]] = true;

            max = Math.max(max, i-left+1);
        }

        return max;
    }
}