class Solution {
    public String reverseStr(String s, int k) {
        int count = 0;
        boolean flag = true;
        String res = "", temp = "";
        for(Character item: s.toCharArray()) {
            if (count < k && flag) {
                temp = item + temp;
            } else {
                temp = temp + item;
            }
            count ++;
            if (count == k) {
                count = 0;
                flag = !flag;
                res = res + temp;
                temp = "";
            }
        }
        res = res + temp;
        return res;        
    }
}