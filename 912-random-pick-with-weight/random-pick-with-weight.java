class Solution {
    int sum;
    int[] prob;
    Random rand;

    public Solution(int[] w) {
        prob = new int[w.length];
        sum = 0;
       
        for(int i=0; i<w.length; i++) {
            sum += w[i];
            prob[i] = sum;
        }

        rand = new Random();
    }
    
    public int pickIndex() {
        int i = rand.nextInt(sum)+1;
        int low = 0, high = prob.length-1;

        while(low<high) {
            int mid = low + ((high-low)/2);
            if(prob[mid] < i)
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