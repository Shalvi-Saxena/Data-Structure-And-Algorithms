class Solution {
    public boolean checkVowel(char s) {
        return (s == 'A' || s == 'a' ||
                s == 'E' || s == 'e' ||
                s == 'I' || s == 'i' ||
                s == 'O' || s == 'o' ||
                s == 'U' || s == 'u');
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int f=0, l=arr.length-1;
        
        for (f=0; f<l; f++) {
                    
            if(checkVowel(arr[f])) {
                for (; l>f; l--) {
                    if (checkVowel(arr[l])) {
                        char temp = arr[l];
                        arr[l] = arr[f];
                        arr[f] = temp;
                        l--;
                        break;
                    }
                }   
            }
        }
        return new String(arr);        
    }
}