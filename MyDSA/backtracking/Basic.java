package MyDSA.backtracking;

import java.util.Arrays;

public class Basic {

    static void change_array(int[] arr , int i) {
        if (i == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[i] = i + 1;
        change_array(arr, i + 1);
        arr[i] -= 2; // backtracking step
    }
    
    public static void main(String[] args) {
        int[] arr = new int[5];
        change_array(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
