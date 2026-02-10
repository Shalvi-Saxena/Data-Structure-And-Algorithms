class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)    return 0;
        
        int maxL = 0, count = 0;
        int[] dict = new int[255];
        char[] arr = s.toCharArray();

        for(int left=0, i=0; i<s.length(); i++) {
            if(dict[arr[i]] == 0) {
                count++;
            }

            dict[arr[i]]++;
            
            while(count > k) {
                dict[arr[left]]--;
                if(dict[arr[left]] == 0) {
                    count--;
                }
                left++;
            }

            if(count <= k) {
                maxL = Math.max(maxL, i-left+1);
            }
        }

        return maxL;
    }
}