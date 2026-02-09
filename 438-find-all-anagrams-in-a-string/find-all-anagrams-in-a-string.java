class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(char ch: p.toCharArray()) {
            arr1[ch-'a']++;
        }

        List<Integer> res = new ArrayList<>();
        char[] str = s.toCharArray();

        for(int left=0, i=0; i<str.length; i++) {
            int ind = str[i]-'a';
            arr2[ind]++;

            while(arr2[ind] > arr1[ind]) {
                int leftInd = str[left++]-'a';
                arr2[leftInd]--;
            }

            if((i-left+1) == p.length()) {
                res.add(left);
            }
        }

        return res;
    }
}