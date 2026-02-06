class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> arr = new ArrayList<>();
        HashSet<String> keys = new HashSet<>();

        int l=0, r=nums.length-1;

        for(; l<nums.length; l++) {
            for(r = nums.length-1; r>l; r--) {

                long sum = nums[l]+nums[r];
                int iL = l+1, iR = r-1;

                while(iL < iR) {
                    long currSum = sum+nums[iL]+nums[iR];
                    if(currSum == target) {
                        String key = nums[l]+"_"+nums[iL]+"_"+nums[iR]+"_"+nums[r];
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