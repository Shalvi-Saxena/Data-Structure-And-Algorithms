class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int item: nums) {
            if(set.contains(item)) {
                set.remove(item);
            } else {
                set.add(item);
            }
        }
        for(Integer i: set) {
            return i;
        }
        return 0;
    }
}