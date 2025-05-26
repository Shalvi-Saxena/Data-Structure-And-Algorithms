class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        int a,b;
        for(String token: tokens) {
            switch(token) {
                case "+":
                    a = list.removeFirst();
                    b = list.removeFirst();
                    list.addFirst(a+b);
                    break;
                case "-":
                    a = list.removeFirst();
                    b = list.removeFirst();
                    list.addFirst(b-a);
                    break;
                case "*":
                    a = list.removeFirst();
                    b = list.removeFirst();
                    list.addFirst(a*b);
                    break;
                case "/":
                    a = list.removeFirst();
                    b = list.removeFirst();
                    list.addFirst(b/a);
                    break;
                default:
                    list.addFirst(Integer.valueOf(token));
            }
        }
        return list.removeFirst();
    }
}