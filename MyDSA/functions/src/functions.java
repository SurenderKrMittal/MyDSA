import java.util.*;

public class functions {
    
    public static int product(int a , int b){
        return (a*b);
    }
   
    public static float product(float a, float b) { //method overloading using data types
        return ((float)a * b); 
    }

    public static int product(int a, int b, int c) { // method overloading using parameters
        return (a * b * c);
    }

    public static int factorial(int n){
        int fact = 1;
        if(n == 0){
            return 1;
        }else{
            for(int i = 1; i <= n; i++) {
                fact *= i;
            }
        }      

        return fact;        
    }

    public static int bincoef(int n, int r) {
        int a = factorial(n);
        int b = factorial(r);
        int c = factorial(n - r);
        return (a / (b*c));
    }

    public static boolean isprime(int n) {
        if(n == 2) {
            return true;
        } else{
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void primerange(int n) {
        for(int i = 2; i <= n; i++) {
            boolean num = isprime(i);
            if(num){
                System.out.print(i + " ");
            }
        }
    }

    public static int bin2dec(int binnum) {
        int pow = 0;
        int decnum = 0;
        while(binnum > 0) {
             int ld = binnum % 10;
             decnum += (ld * (int)(Math.pow(2, pow)));
             pow++;
             binnum /= 10;
        }
        return decnum;

    }

    public static int dec2bin(int decnum) {
        int pow = 0;
        int binnum = 0;
        while(decnum > 0) {
            int rem = decnum % 2;
            binnum += (rem * (int)(Math.pow(10, pow)));
            pow ++;
            decnum /= 2;
        }
        return binnum;
    }

    public static int average(int a, int b, int c) {
        return ((a + b + c)/3);
    }

    public static boolean iseven(int n) {
        if(n % 2 == 0) {
            return true;
        } else{
            return false;
        }
    }

    public static int reverse(int n) {
        int rev = 0;
        while(n > 0) {
            int ld = n % 10;
            rev = ld + (rev * 10);
            n /= 10;
        }
        return rev;
    }

    public static boolean ispalindrome(int n){
        int orig = n;
        n = reverse(n);
        if(orig == n){
            return true;
        } else{
            return false;
        }
    }

    public static int sumofdigits(int n) {
       int sum = 0;
        while(n > 0) {
            int ld = n % 10;
            sum += ld;
            n /= 10;
        }
        return sum;
    }

    public static int max(int a, int b) {
        return (Math.max(a, b));
    } 

    public static int min(int a, int b) {
        return (Math.min(a, b));
    }

    public static int power(int a, int b) {
        return (int)(Math.pow(a, b));
    }

    public static double sqrt(int a) {
        return Math.sqrt(a);
    }

    public static int absolute(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(power(x,y));
    }
}
