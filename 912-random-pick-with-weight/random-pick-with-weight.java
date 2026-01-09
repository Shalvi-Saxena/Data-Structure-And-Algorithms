class Solution {
    int sum;
    ArrayList<Integer> prob;
    Random rand;

    public Solution(int[] w) {
        prob = new ArrayList<>();
        sum = 0;
       
        for(int j: w) {
            sum += j;
            prob.add(sum);
        }

        rand = new Random();
    }
    
    public int pickIndex() {
        int i = rand.nextInt(sum)+1;
        int low = 0, high = prob.size()-1;

        while(low<high) {
            int mid = low + ((high-low)/2);
            if(prob.get(mid) < i)
                low = mid+1;
            else
                high = mid;
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */