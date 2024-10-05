class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1, arr2;
        if(num1.length() > num2.length()) {
            arr1 = num1.toCharArray();
            arr2 = num2.toCharArray();
        } else {
            arr1 = num2.toCharArray();
            arr2 = num1.toCharArray();
        }
        int i=arr1.length-1, j=arr2.length-1, c=0;
        String res = "";
        for(; i>=0 && j>=0; i--, j--) {
            int sum = arr1[i]-48+arr2[j]-48+c;
            if(sum > 9) {
                c = 1;
                sum -= 10;
            } else {
                c=0;
            }
            res = sum+res;
        }
        for(; i>=0; i--) {
            int sum = arr1[i]-48+c;
            if(sum > 9) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            res = sum+res;
        }
        for(; j>=0; j--) {
            int sum = arr2[j]-48+c;
            if(sum > 9) {
                c = 1;
                sum -= 10;
            } else {
                c = 0;
            }
            res = sum+res;
        }
        if(c > 0) {
            res = c+res;
        } 
        return res;
    }
}