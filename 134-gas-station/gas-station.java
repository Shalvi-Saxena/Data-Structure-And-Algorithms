class Solution {
    public boolean isAllowed(int[] gas, int[] cost, int i, int n) {
        int sum = 0;
        for(int j=i; j<n && sum >= 0; j++) {
            sum += gas[j]-cost[j];
        }
        for(int j=0; j<i && sum >= 0; j++) {
            sum += gas[j]-cost[j];
        }

        return sum>=0;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        
        for(int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int currGas = 0, start = 0;

        for(int i=0; i<n; i++) {

            currGas += gas[i] - cost[i];
            if(currGas < 0) {
                currGas = 0;
                start = i+1;
            }
        }
        return start;
    }
}