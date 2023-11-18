package MyDSA.maths;
public class Prime {

    // check if a number is prime or not
    static boolean is_prime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i < n; i++) {
            if (i % n == 0) {
                return false;
            }
        }
        return true;
    }

    // sieve of eratosthenes
    static void sieve(int n , boolean[] arr) {
        for (int i = 2; i * i <= n; i++) {
            // as the default value in the array is false instead of converting the whole array to true we are taking
            // values marked as false as prime and values marked true as composite
            if (!arr[i]) {
                for (int j = i * 2; j <= n; j += i){
                    arr[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!arr[i]) {
                System.out.println(i + " is prime");
            }
        }
    }

    public static void main(String[] args) {
        int n = 40;
        // (n + 1) because i want the indices of the number to be the same as there value
        // for (n) the indexes will be 0 to 39
        boolean[] arr = new boolean[n + 1]; 
        sieve(n , arr);
        
    }
}
