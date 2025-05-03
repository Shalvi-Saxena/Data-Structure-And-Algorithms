class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char item : t.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int matched = 0, start = 0, minLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map2.get(c).intValue() == map.get(c).intValue()) {
                    matched++;
                }
            }

            while (matched == map.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map2.put(leftChar, map2.get(leftChar) - 1);
                    if (map2.get(leftChar) < map.get(leftChar)) {
                        matched--;
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
