class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int max = arr.length-2;

        while(max>=0 && arr[max] >= arr[max+1]) {
            max--;
        }
        if(max<0) {
            return -1;
        }

        int min = arr.length-1;

        while(min>=0 && arr[min] <= arr[max]) {
            min--;
        }

        swap(arr, min, max);
        reverse(arr, max+1);

        try {
            return Integer.valueOf(new String(arr));
        } catch(Exception ex) {
            return -1;
        }
    }

    private void reverse(char[] arr, int i) {
        int j = arr.length-1;
        while(i<j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--; 
        }
    }

    private void swap(char[] arr, int min, int max) {
        char temp = arr[min];
        arr[min] = arr[max];
        arr[max] = temp;
    }
}