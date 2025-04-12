class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character item: s.toCharArray()) {
            map.put(item, map.getOrDefault(item,0)+1);
        }
        int len = 0;
        boolean isOdd = false;

        for(Integer count: map.values()) {
            int odd = count & 1;
            if(odd == 1) {
                count--;
                isOdd = true;
            }
            len += count;
        }

        return len + (isOdd ? 1:0);
    }
}