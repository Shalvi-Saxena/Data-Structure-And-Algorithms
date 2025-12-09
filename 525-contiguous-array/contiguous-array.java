class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int maxLength = 0, sum=0;
        int[] val = {-1,1};

        for(int i=0; i<nums.length; i++) {
            sum += val[nums[i]];
            
            if(map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}