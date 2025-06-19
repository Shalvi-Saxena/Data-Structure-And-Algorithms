class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0)   return 0;

        HashMap<Character, Integer> keys = new HashMap<>();
        keys.put('I', 1);
        keys.put('V', 5);
        keys.put('X', 10);
        keys.put('L', 50);
        keys.put('C', 100);
        keys.put('D', 500);
        keys.put('M', 1000);

        char[] arr = s.toCharArray();
        int val = 0;

        for(int i=arr.length-1; i>=0; i--) {
            val += keys.get(arr[i]);
            int j = keys.get(arr[i]);

            while(i>0 && keys.get(arr[i-1]) < j) {
                val -= keys.get(arr[i-1]);
                i--;
            }

            // System.out.println("val = "+val+" i = "+i+" j ="+j);
            
        }

        return val;
    }
}