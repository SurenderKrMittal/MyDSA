package Divide_and_Conquer;

import java.util.Arrays;

public class Quick_sort {

    public static void quickSort(int[] arr , int start , int end) {
        if (start >= end) {
            return;
        }
        int pivot_indx = partition(arr , start , end);
        quickSort(arr, start, pivot_indx - 1);
        quickSort(arr, pivot_indx + 1, end);
    }

    public static int partition(int[] arr , int start , int end) {
        int pivot = arr[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr , i , j);
            }
        }
        i++;
        swap(arr , i , end);
        return i;
    }

    public static void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6 , 3 , 9, 8, 2, 5 , -2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
