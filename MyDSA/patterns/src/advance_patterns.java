import java.util.*;

public class advance_patterns {
    
    public static void hollow_rectangle(int n, int m) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1 || i == n || j == 1 || j == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void inv_rot_half_pyramid(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void inv_half_pyramid(int n){
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i+1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floyd_triangle(int n) {
        int num = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num ++;
            }
            System.out.println();
        }
    }

    public static void triangle(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        for(int i = 1; i <= n; i++)  {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for(int j = 1; j <= 2*(n-i); j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for(int j = 1; j <= 2*(n-i); j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" "); 
            }
            for(int j = 1; j <= n; j++) {
                if(i == 1 || i == n || j == 1 || j == n ) {
                    System.out.print("* ");
                }else   {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n ; i >= 1; i--) {
            for(int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void num_pyramid(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print(i + " " );
            }
            System.out.println();
        }
    }

    public static void palin_pyramid(int n) {
        for(int i = 1; i <= n; i++) {
            int num = i;
            int num2 = 2;
            for(int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num --;
            }
            for(int j = 1; j <= i-1; j++) {
                System.out.print(num2 + " ");
                num2 ++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        palin_pyramid(x);
    }
}
