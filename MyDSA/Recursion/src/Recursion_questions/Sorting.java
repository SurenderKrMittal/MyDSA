package Recursion_questions;

import java.util.Arrays;

public class Sorting {

    static void bubble_sort(int[] arr , int n , int i) { // could create helper function to get n = arr.length - 1
        if (n == 0){
            return;
        }
        if (i < n) {
            if (arr[i] > arr[i + 1]) { // here we will take n as arr.length - 1 to avoid index out of bounds error
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;   
            }
            bubble_sort(arr, n, i + 1);
        } else {
            bubble_sort(arr, n - 1, 0);
        }
    }

    static void selection_sort(int[] arr , int max_indx , int n , int i) {
        if (n == 0) {
            return;
        }
        if (i < n) {
            if (arr[i] > arr[max_indx]) { // here we will take n as arr.length to include last index 
                max_indx = i;
            }
            selection_sort(arr, max_indx, n, i + 1);
        } else {
            int temp = arr[n];
            arr[n] = arr[max_indx];
            arr[max_indx] = temp;
            selection_sort(arr, 0, n - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4 , 13, 2 ,10};
        selection_sort(arr , 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }
}
