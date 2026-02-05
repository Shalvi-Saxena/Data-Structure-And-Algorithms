class Solution {
    public int numOfWays(int n) {
        long abc = 6, aba = 6;
        int mod = 1000000007;

        for(int i=1; i<n; i++) {
            long typeAbc = (2*abc + 2*aba) % mod;
            long typeAba = (2*abc + 3*aba) % mod;
            abc = typeAbc;
            aba = typeAba;
        }

        return (int)((abc + aba) % mod);
    }
}