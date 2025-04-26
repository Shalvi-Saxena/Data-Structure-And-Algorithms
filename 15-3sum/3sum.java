class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2 && nums[i] <= 0; i++) {
            int j=i+1, k=nums.length-1;
            // System.out.println("i = "+i+" j = "+j+" k = "+k);
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                // System.out.println("i = "+i+" j = "+j+" k = "+k+" sum = "+sum);
                if(sum > 0) {
                    while(j<k && nums[k] == nums[--k]);
                } else if(sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    res.add(triplet);
                    while(j<k && nums[j] == nums[++j]);
                    while(j<k && nums[k] == nums[--k]);
                } else if(sum < 0) {
                    while(j<k && nums[j] == nums[++j]);
                }
            }
            while(i<nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        
        return res;
    }
}