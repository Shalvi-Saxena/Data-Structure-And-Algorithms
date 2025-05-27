class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 1) {
            return s.length();
        }

        boolean[] count = new boolean[128];
        char[] arr = s.toCharArray();
        int maxLen = 0, left=0, right=0;

        for(; left<=right && right < arr.length; right++) {
            int ind = arr[right];
            if(count[ind]) {
                while(arr[left] != arr[right]) {
                    count[arr[left]] = false;
                    left++;
                }
                count[arr[left]] = false;
                left++;
            }
            count[ind] = true;
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}