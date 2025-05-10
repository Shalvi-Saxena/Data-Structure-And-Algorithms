class Solution {
    int[] primes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
        41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) key *= primes[c - 'a'];

            if (map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(key, value);
                res.add(value);
            }
        }
        return res;
    }
}