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

    // find xor from 0 till a
    static int xor_till_a(int a) {
        int mod = a % 4;
        switch (mod) {
            case 0 : return a;
            case 1 : return 1;
            case 2 : return a + 1;
            case 3 : return 0;
        }
        throw new IllegalArgumentException("Invalid value of 'a'");
    }

    // find xor from a to b
    static int xor_range(int a , int b) {
        return xor_till_a(b) ^ xor_till_a(a - 1);
    }

    static int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int start = 0;
            int end = image[0].length - 1;
            while (start <= end) {
                int temp = row[start] ^ 1;
                row[start] = row[end] ^ 1;
                row[end] = temp;
                start ++;
                end --;
            }
        }
        return image;
    }

    public static void main(String[] args) {
            // int[] n = {1,2,2,4,3,4,6,3,1};
            // System.out.println(No_of_digits(11 , 2));
            System.out.println(xor_range(3, 9));
    }
}
