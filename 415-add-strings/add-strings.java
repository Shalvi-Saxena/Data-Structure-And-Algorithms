class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1, arr2;
        // if(num1.length() > num2.length()) {
            arr1 = num1.toCharArray();
            arr2 = num2.toCharArray();
        // } else {
        //     arr1 = num2.toCharArray();
        //     arr2 = num1.toCharArray();
        // }
        String res = "";
        for(int i=arr1.length-1, j=arr2.length-1, c=0; i>=0 || j>=0 || c>0; i--, j--) {
            int a = i>=0? arr1[i]-'0':0;
            int b = j>=0? arr2[j]-'0':0;
            int sum = (a+b+c)%10;
            res = sum+res;
            c = (a+b+c)/10;
        }
        return res;
    }
}