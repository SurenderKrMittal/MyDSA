package Recursion_Basics;

public class Recursion_Basics {

    public static void printlistdecreasing (int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        System.out.print(n + " ");
        printlistdecreasing(n - 1);
    }

    public static void printlistasc(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }
        printlistasc(n - 1);
        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1; 
        }
        int fn_1 = fact(n - 1);
        return n * fn_1;
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int sumnm1 = sum(n - 1);
        int sum = n + sumnm1;
        return sum; 
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int sumnm1 = fib(n - 1);
        int sumnm2 = fib(n - 2);
        return sumnm1 + sumnm2;
    }

    public static boolean issorted(int[] arr , int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] <= arr[i + 1]) {
            boolean ans = issorted(arr, i + 1);
            return ans;
        }
        return false;
    }

    public static int first_occurence(int[] arr , int i , int key) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return first_occurence(arr, i + 1, key);
    }

    public static int last_occurence(int[] arr , int key , int i) {
        if (i == arr.length) {
            return -1;
        }
        int isfound = last_occurence(arr, key, i + 1);
        if (isfound == -1 && arr[i] == key) {
            return i;
        }
        return isfound;
    }

    public static void main(String[] args) {
        int[] arr = {8 , 3 , 6 , 9 , 5 , 10 , 2 , 5 , 3};
        System.out.println();
    }
}
