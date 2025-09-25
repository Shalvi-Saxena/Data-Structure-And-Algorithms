class Solution {
    public int missingNumber(int[] nums) {
        int max = 0;
        for(int i: nums) {
            max = Math.max(i, max);
        }
        boolean[] arr = new boolean[max+1];

        for(int i: nums) {
            arr[i] = true;
        }

        for(int i=0; i<=max; i++) {
            if(!arr[i]) {
                return i;
            }
        }

        return max+1;
    }
}