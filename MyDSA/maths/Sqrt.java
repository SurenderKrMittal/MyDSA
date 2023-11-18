package MyDSA.maths;

public class Sqrt {
    
    static double sqrt(int n , int p) {
        int s = 0;
        int e = n;
        double root = 0.0;
        while (e <= s) {
            int m = s + (e - s) / 2;
            if (m * m == n) {
                return m;
            }
            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                root = m;  // root * root has to be smaller than n
            }
        }
        double inc = 0.1;
        for (int i = 0; i < p; i++) { // p is precision in decimal point
            while (root * root < n) {
                root += inc;
            }
            root -= inc;
            inc /= 10;
        }
        return root;
    }

    // newton's raphson method
    static double newton_sqrt(int n) {
        double x = n;
        double root;
        while(true) {
            root = 0.5 * (x + (n / x));
            if(Math.abs(root - x) < 0.5){
                break;
            }
            x = root;
        }
        return root;
    }

    public static void main(String[] args) {
        // System.out.printf("%.3f",sqrt(40, 3));
        System.out.println("Newton Raphson Method: " + newton_sqrt(40));
    }
}
