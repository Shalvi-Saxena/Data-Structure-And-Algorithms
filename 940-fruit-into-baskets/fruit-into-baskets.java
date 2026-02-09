class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 1) {
            return fruits.length;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, maxCount = 0;

        for(int i=0, left = 0; i<fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0)+1);
            count++;

            if(map.size() > 2) {
                while(map.size() > 2) {
                    int fruit = fruits[left];
                    map.put(fruit, map.get(fruit)-1);
                    count--;
                    if(map.get(fruit) == 0) {
                        map.remove(fruit);
                    }
                    left++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}