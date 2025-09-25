class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int item: nums) {
            sum = item ^ sum;
        }
        return sum;
    }
}