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

        for(int i=0, j=arr.length-1; i<j;) {
            if(checkValidNumChar(arr[i]) && checkValidNumChar(arr[j])) {
                if(arr[i] != arr[j]) {
                    return false;
                }
                i++;
                j--;
            } 
            while( i<j && !checkValidNumChar(arr[i])) {
                i++;
            } 
            while ( j>i && !checkValidNumChar(arr[j])) {
                j--;
            }

        }
        return true;
    }
}