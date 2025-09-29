class Solution {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int s = 0, l = arr.length-1;

        while(s<l) {
            if(arr[s] != arr[l]) {
                return false;
            }
            s++;
            l--;
        }

        return true;
    }
}