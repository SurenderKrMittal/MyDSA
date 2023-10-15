public class Main {

    public static String odd_even (int n) {
        if ((n & 1) == 0) {
            return "Even";
        }
        return "Odd";
    }

    public static int unique (int[] arr) {
        int ans = 0;
        for (int n : arr ) {
            ans ^= n;
        }
        return ans;
    }

    public static int magic_no (int n) {
        int ans = 0;
        int pow = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans += ((n & 1) * (int)(Math.pow(5 , pow)));
            }
            n = n >> 1;
            pow++;
        }
        return ans;
    }

    public static int No_of_digits (int n  , int base) {
        int ans = (int) (Math.log(n) / Math.log(base)) + 1 ;
        return ans;
    }

    public static void main(String[] args) {
            int[] n = {1,2,2,4,3,4,6,3,1};
            System.out.println(No_of_digits(11 , 2));
    }
}
