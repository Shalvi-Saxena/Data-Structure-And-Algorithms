class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        HashMap<Character, Character> paren = new HashMap<>();
        paren.put('}', '{');
        paren.put(']', '[');
        paren.put(')', '(');
        for(Character item: str.toCharArray()) {
            switch(item) {
                case '{':
                case '(':
                case '[':
                    s.push(item);
                    break;
                case '}':
                    if(s.size() == 0)
                            return false;
                    if(Character.compare(paren.get(item), s.pop()) != 0)
                        return false;
                    break;
                case ')':
                    if(s.size() == 0)
                        return false;
                    if(Character.compare(paren.get(item), s.pop()) != 0)
                        return false;
                    break;
                case ']':
                    if(s.size() == 0)
                        return false;
                    if(Character.compare(paren.get(item), s.pop()) != 0)
                        return false;
                    break;
            }
        }
        return s.size() == 0;
    }
}