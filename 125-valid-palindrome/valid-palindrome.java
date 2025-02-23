class Solution {
    public boolean checkValidNumChar(char item) {
        if((item >= 'a' && item <= 'z') || (item >= '0' && item <= '9')) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();

        for(int i=0, j=arr.length-1; i<arr.length && i<=j;) {

            if(checkValidNumChar(arr[i]) && checkValidNumChar(arr[j])) {
                System.out.println("i = "+i+". j = "+j);
                if(arr[i] != arr[j]) {
                    return false;
                }
                i++;
                j--;
            } else if(!checkValidNumChar(arr[i])) {
                i++;
            } else if(!checkValidNumChar(arr[j])) {
                j--;
            }

        }
        return true;
    }
}