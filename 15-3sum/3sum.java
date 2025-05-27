class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();
        int n=nums.length, sum=0;

        if(nums[n-1] < 0)   return triplets;

        for(int i=0; i<(n-2) && nums[i]<=0; i++) {
            int j = i+1, k = n-1;

            while(j<k) {
                sum = nums[i]+nums[j]+nums[k];
                if(sum < 0) {
                    while(j<k && nums[j] == nums[++j]);
                } else if(sum > 0) {
                    while(j<k && nums[k] == nums[--k]);
                }
                else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    triplets.add(triplet);
                    while(j<k && nums[j] == nums[++j]);
                    while(j<k && nums[k] == nums[--k]);
                }
            }
            while(i<n-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return triplets;
    }
}