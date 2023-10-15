package Divide_and_Conquer;

public class Rotated_Binary_Search {

    public static int search(int[] arr , int key , int start , int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && arr[mid] > key) {
                return search(arr, key, start, mid - 1);
            }else {
                return search(arr, key, mid + 1, end);
            }
        } else{
            if (arr[mid] < key && arr[end] >= key) {
                return search(arr, key, mid + 1, end);
            } else {
                return search(arr, key, start, mid - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4 , 5, 6 , 7, 8, 1 , 2, 3};
        int ans = search(arr, 5, 0, arr.length - 1);
        System.out.println(ans);
    }
}
