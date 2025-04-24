class Solution {
    public int getValue(String op, String b, String a) {
        int a1 = Integer.valueOf(a), b1 = Integer.valueOf(b);
        switch(op) {
            case "+":
                return a1+b1;
            case "-":
                return a1-b1;
            case "*":
                return a1*b1;
            default:
                return a1/b1;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<String> exp = new Stack<>();

        for(String token: tokens) {
            if(exp.isEmpty()) {
                exp.push(token);
            } else {
                if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    exp.push(String.valueOf(getValue(token, exp.pop(), exp.pop())));
                } else {
                    exp.push(token);
                }
            }
        }
        return Integer.valueOf(exp.peek());
    }
}