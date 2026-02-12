class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        // s1: indices looking for their 1st greater element
        // s2: indices looking for their 2nd greater element
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        // Temporary storage to maintain order when moving from s1 to s2
        Deque<Integer> temp = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Check if nums[i] is the SECOND greater element for s2
            while (!s2.isEmpty() && nums[s2.peek()] < nums[i]) {
                res[s2.pop()] = nums[i];
            }
            
            // 2. Check if nums[i] is the FIRST greater element for s1
            // If so, move them to the "waiting room" (s2)
            while (!s1.isEmpty() && nums[s1.peek()] < nums[i]) {
                temp.push(s1.pop());
            }
            
            // 3. Move from temp to s2 so s2 stays sorted
            while (!temp.isEmpty()) {
                s2.push(temp.pop());
            }
            
            // 4. Add current index to s1
            s1.push(i);
        }
        
        return res;
    }
}