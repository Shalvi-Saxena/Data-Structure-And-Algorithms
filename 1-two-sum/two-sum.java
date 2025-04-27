import java.util.*;
import java.lang.*;
import java.io.*; 

class Solution {
    public int[] twoSum(int[] num, int target) {
        HashMap<Integer, Integer> compliments = new HashMap<>();

        for(int i=0; i<num.length; i++) {
            int compliment = target-num[i];
            if(compliments.containsKey(compliment)) {
                return new int[]{i, compliments.get(compliment)};
            }
            compliments.put(num[i], i);
        }
        return new int[2];
    }
}