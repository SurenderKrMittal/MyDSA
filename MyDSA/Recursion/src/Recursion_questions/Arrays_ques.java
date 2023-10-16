package Recursion_questions;

import java.util.ArrayList;

public class Arrays_ques {

    static boolean isSorted(int[] arr ) {
        return helper_Issorted(arr , 0);
    }

    static boolean helper_Issorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] < arr[i + 1]) {
            return helper_Issorted(arr, i + 1); // a different reference variable arr is created at every recursion call but they are
        } // pointing towards same object . ASo if you modify object in any one recursion call, it will be modified for all variables.
        return false;
        // return (arr[i] < arr[i + 1]) && helper_Issorted(arr , i + 1);
        // above statement is shorter way to write.
    }

    static int linear_search(int[] arr , int key) {
        return helper_linear_search(arr , key , 0); // to check from back go from arr.length - 1 to -1
    }

    static int helper_linear_search(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return helper_linear_search(arr, key, i + 1);
        // return arr[i] == target || helper_linear_search(arr , key , i + 1) to return boolean value
    }

    // to store all indexes in linear search
    static ArrayList<Integer> list = new ArrayList<>();
    static void find_all_indexes(int[] arr , int key , int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            list.add(i);
        }
        find_all_indexes(arr, key, i + 1);
    }

    // if you pass arraylist as argument
    static ArrayList<Integer> find_all_indexes_2(int[] arr , int key , int i , ArrayList<Integer> list) {
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == key) {
            list.add(i);
        }
        return find_all_indexes_2(arr, key, i + 1, list);
    }

    //if arraylist is in body of function
    static ArrayList<Integer> find_all_indexes_3(int[] arr , int key , int i) {

        ArrayList<Integer> list1 = new ArrayList<>();  // this is an inefficient way as a new object is being created at every call.

        if (i == arr.length) {
            return list1;
        }
        if (arr[i] == key) {
            list1.add(i);
        }
        ArrayList<Integer> ansfromcall = find_all_indexes_3(arr, key, i + 1);
        list1.addAll(ansfromcall);
        return list1;
    }

    static int binary_search(int[] arr , int key , int start , int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binary_search(arr, key, mid + 1, end);
        }
        return binary_search(arr, key, start, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 3 , 3 , 4 , 5};
        ArrayList<Integer> ans = find_all_indexes_3(arr , 3 , 0); 
        System.out.println(ans);
    }
}
