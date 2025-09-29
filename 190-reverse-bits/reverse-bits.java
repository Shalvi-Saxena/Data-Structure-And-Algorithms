class Solution {
    public int reverseBits(int n) {
        int rev = 0, i = 32;
        while(i-- > 0) {
            rev = (rev<<1)|(n&1);
            n >>= 1;
        }
        return rev;
    }
}