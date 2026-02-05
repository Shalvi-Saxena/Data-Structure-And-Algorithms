class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {            
            if(arr[i] == 0) {
                count++; 
            }
        }

        int n = arr.length+count;
        
        for(int read=arr.length-1, write=n-1; read >= 0; write--, read--) {

            if (write < arr.length) {
                arr[write] = arr[read];
            }

            if (arr[read] == 0) {
                write--;
                if (write < arr.length) {
                    arr[write] = 0;
                }
            }
        }
    }
}