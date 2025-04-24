class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> exp = new Stack<>();
        int a,b;

        for(String token: tokens) {
            switch(token) {
                case "+":
                    b = exp.pop();
                    a = exp.pop();
                    exp.push(a+b);
                    break;
                case "-":
                    b = exp.pop();
                    a = exp.pop();
                    exp.push(a-b);
                    break;
                case "/":
                    b = exp.pop();
                    a = exp.pop();
                    exp.push(a/b);
                    break;
                case "*":
                    b = exp.pop();
                    a = exp.pop();
                    exp.push(a*b);
                    break;
                default:
                    exp.push(Integer.parseInt(token));
            }
        }
        return Integer.valueOf(exp.peek());
    }
}