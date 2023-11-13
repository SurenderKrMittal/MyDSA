package Recursion_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    // to do the subset pattern via iteration

    // to print all subsets of a array
    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    // to print all subsets of a array with duplicate element
    static List<List<Integer>> subset_duplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current element is a duplicate
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
    
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3};
        // List<List<Integer>> ans = subset(arr);
        List<List<Integer>> ans = subset_duplicate(arr);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
        
    }
    
}
