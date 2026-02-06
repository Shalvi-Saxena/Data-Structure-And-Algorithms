class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> arr = new ArrayList<>();
        HashSet<String> keys = new HashSet<>();

        int l=0, r=nums.length-1;

        for(; l<nums.length; l++) {
            for(r = l+1; r<nums.length; r++) {

                long sum = nums[l]+nums[r];
                int iL = r+1, iR = nums.length-1;

                while(iL < iR) {
                    long currSum = sum+nums[iL]+nums[iR];
                    if(currSum == target) {
                        String key = nums[l]+"_"+nums[r]+"_"+nums[iL]+"_"+nums[iR];
                        if(!keys.contains(key)) {
                            arr.add(Arrays.asList(nums[l], nums[iL], nums[iR], nums[r]));
                            keys.add(key);
                        }
                    }

                    if(currSum < target) {
                        iL++;
                    } else {
                        iR--;
                    }
                }
            }
        }

        return arr;        
    }
}