package Recursion_questions;

public class Level1 {

    static int sumOfDigits(int n) {
        if(n == 0){
            return 0;
        }
//        int rem = n % 10;
        return n % 10 + sumOfDigits(n / 10);
    }

    static int productOfDigits(int n) {
        if(n % 10 == n){
            return n;
        }
        return n % 10 * productOfDigits(n / 10);
    }

    static int sum = 0;
    static void reverse_number1(int n) {
        if (n == 0) {
            return;
        }
        sum = (sum * 10) + n % 10;
        reverse_number1(n / 10);
    }

    static int reverse_number2(int n) {
        int digits = (int)(Math.log10(n));
        return helper(n , digits);
    }

    static int helper(int n , int digits) {
        if (n % 10 == n) {
            return n;
        }
        return ((n % 10) * (int)(Math.pow(10 , digits))) + helper(n / 10 , digits - 1);
    }

    static boolean isPalindrome(int n) {
        int rev = reverse_number2(n);
        if (rev == n) {
            return true;
        }
        return false;
    }

    static int count_zeroes(int n) {
        return helper_count_zeroes(n , 0); // helper function is created because we need to  pass the count(0) as an argument
    }                                     // to the recursion calls.

    static int helper_count_zeroes(int n , int count) {
        if(n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            return helper_count_zeroes(n / 10 , count + 1);
        }
        return helper_count_zeroes(n / 10 , count);
    }

    static int numberofsteps(int n) {
        return helper_steps(n , 0);
    }

    static int helper_steps(int n , int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            return helper_steps(n / 2 , count + 1);
        }
        return helper_steps(n - 1 , count + 1);
    }

    // For a given integer array of siz eN.You have to find all the occurrences (indices) of a given element (Key) and print them
    static void occur(int[] arr , int key , int i) {
        if (i >= arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i);
        }
        occur(arr, key, i + 1);
    }

    // You are given a number (eg -  2019), convert it into a String of english "two zero one nine"
    static String[] digits =  {"zero" , "one" , "two" , " three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
    static String convert(int n) {
        if (n == 0) {
            return "";
        }
        int digit = n % 10;
        String ch = digits[digit];
        String a = convert(n / 10);
        return a + ch + " ";
    }

    // length of a string
    static int length(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int count = 1;
        count += length(str.substring(1));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(length( "sbc"));
    }
}

