public class Bit_manipulation {

    public static String odd_even(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static int get_ith_bit (int n , int i) {
        int bitMask = (1 << i);
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    } 

    public static int set_ith_bit (int n , int i) {
        int bitMask = 1 << i;
        n = n | bitMask;
        return n;
    }

    public static int clear_ith_bit (int n , int i) {
        int bitMask = ~(1 << i);
        n = n & bitMask;
        return n;
    }

    public static int update_ith_bit (int n , int i , int newBit) {
        // if (newBit == 0) {
        //     return clear_ith_bit(n, i);
        // } else {
        //     return set_ith_bit(n, i);
        // }
        
        // Anotheer Approach

        n = clear_ith_bit(n, i);
        int BitMask = newBit << i;
        n = n | BitMask;
        return n;
    }

    public static int clear_last_i_bits (int n , int i) {
        // for (int j = 0; j < i; j++) {
        //     n = clear_ith_bit(n, j);
        // }
        // return n;

        int bitMask = (~0) << i;
        n = n & bitMask;
        return n;
    }

    public static int clear_range (int n, int i , int j) {
        // for (int k = i; k <= j; k++) {
        //     n = clear_ith_bit(n, k);
        // }
        // return n;

        int a = ((~0) << j + 1);
        int b = ((1 << i) - 1);
        int BitMask = a | b;
        n = n & BitMask;
        return n;
    }

    public static boolean power_of_2 (int n) {
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static int count_set_bits (int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fast_exponentiation (int a , int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= a;
            } 
            a *= a;
            n = n >> 1;
        }
        return ans;
    }

    // swapping two variables without using 3rd variable
    static void swap(int a , int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    } 

    // adding 1 to integer through bit manipulation
    static int add1(int n) {
        // return -(~n);
        return n | (~n);
    }

    // covert uppercase character to lowercase
    static char convert(char ch) {
        return (char)(ch | ' ');
    }
    

    public static void main (String[] args) {

        System.out.println(convert('A'));
    }
    
}
