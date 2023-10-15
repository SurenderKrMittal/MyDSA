import java.util.*;

public class basic_calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a");
        int a = input.nextInt();
        System.out.println("Enter b");
        int b = input.nextInt();
        System.out.println("Enter operator");
        char operator = input.next().charAt(0);
        switch (operator) {
            case '+' : System.out.println(a+b);
                            break;
            case '-' : System.out.println(a-b);
                            break;
            case '*' : System.out.println(a*b);
                            break;
            case '/' : System.out.println(a/b);
                            break;
            case '%' : System.out.println(a%b);
                            break;
            default : System.out.println("Wrong operator");
        }
    }
}
