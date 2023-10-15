import java.util.Scanner;

public class Main {

    public static void rotated_triangle(int n) {
        for(int i = 1; i <= (2 * n) - 1; i++) {
            if (i > 5) {
                for (int j = 1; j <= (2 * n) - i; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void hourglass(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            if (i <= 5) {
                for (int j = 1; j <= i - 1; j++) {
                    System.out.print(" ");
                }
                for(int j = 1; j <= n - i + 1; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 1; j <= (2 * n) - i; j++) {
                    System.out.print(" ");
                }
                for(int j = 1; j <= i - n; j++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void hollow_diamond(int n) {
        for (int i = 1; i <= (2 * n) - 1; i++) {
            if(i <= 5) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 1; j++) {
                    System.out.print(" *");
                }
                for (int j = 1; j <= (2 * (i - 1)) - 1; j++) {
                    System.out.print(" ");
                }
                if(i != 1) {
                    for (int j = 1; j <= 1; j++) {
                        System.out.print("*");
                    }
                }
            } else {
                for (int j = 1; j <= i - n; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= 1; j++) {
                    System.out.print(" *");
                }
                for (int j = 1; j <= (2 * ((2 * n) - i - 1)) - 1; j++) {
                    System.out.print(" ");
                }
                if(i != 9) {
                    for (int j = 1; j <= 1; j++) {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }

    public static int factorial(int n) {
        int fact = 1;
        while(n > 0) {
            fact *= n;
            n--;
        }
        return fact;
    }

    public static void pascal_triangle(int n) {
// important logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(factorial(i - 1) / (factorial(j - 1) * factorial(i - j)) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        pascal_triangle(x);
    }
}
