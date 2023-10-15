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

    static int count_zeroes(int n , int count) {
        if(n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            return count_zeroes(n / 10 , count + 1);
        } else {
            return count_zeroes(n / 10 , count);
        }
    }

    static int numberofsteps(int n) {
        return helper1(n , 0);
    }

    static int helper1(int n , int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            return helper1(n / 2 , count + 1);
        }
        return helper1(n - 1 , count + 1);
    }

    public static void main(String[] args) {
        System.out.println(numberofsteps(14));
    }
}

