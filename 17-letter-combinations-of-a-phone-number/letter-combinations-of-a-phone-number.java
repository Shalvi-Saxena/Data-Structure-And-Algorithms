class Solution {
    public void dfs(String digits, int i, StringBuilder res, List<List<String>> keypad, List<String> resArr) {
        if(i >= digits.length()) {
            resArr.add(res.toString());
            return;
        }

        int key = digits.charAt(i)-'2';
        for(String item: keypad.get(key)) {
            res.append(item);
            dfs(digits, i+1, res, keypad, resArr);
            res.deleteCharAt(i);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<List<String>> keypad = new ArrayList<>();
        keypad.add(Arrays.asList("a", "b", "c"));
        keypad.add(Arrays.asList("d", "e", "f"));
        keypad.add(Arrays.asList("g", "h", "i"));
        keypad.add(Arrays.asList("j", "k", "l"));
        keypad.add(Arrays.asList("m", "n", "o"));
        keypad.add(Arrays.asList("p", "q", "r", "s"));
        keypad.add(Arrays.asList("t", "u", "v"));
        keypad.add(Arrays.asList("w", "x", "y", "z"));
        if(digits.length() == 1) {
            return keypad.get(digits.charAt(0)-'2');
        }
        List<String> res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), keypad, res);

        return res;
    }
}