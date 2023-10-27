package Divide_and_Conquer;

import java.util.Arrays;

public class Ques {
    public static void main(String[] args) {
        // String[] arr1 = { "sun", "earth", "mars", "mercury"};
        // mergesort(arr1, 0, arr1.length - 1);
        // System.out.println(Arrays.toString(arr1));
        int [] arr = {3 , 2 , 3 , 2 , 2};
        System.out.println(majority(arr));
    }

    static void mergesort(String[] arr , int start , int end) {
        if (start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merge(arr , start , mid , end);
    }

    static void merge(String[] arr, int start, int mid, int end) {
        String[] temp = new String[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < temp.length; k++) {
            arr[k + start] = temp[k];
        }
    }

    // the majority element in the array
    static int majority(int[] arr) {
        return majority_element(arr , 0 , arr.length - 1);
    }

    static int majority_element(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        int left = majority_element(arr, start, mid);
        int right = majority_element(arr, mid + 1, end);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(arr , left, start , mid);
        int rightCount = countInRange(arr, leftCount, mid + 1, end);
        return leftCount > rightCount ? left : right ;
    }

    static int countInRange(int[] arr, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    } // we can also sort the array and take take n/2 element as the majority element in a sorted array will be in the middle pos

    
}
