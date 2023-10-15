import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //fibinacci series
//        System.out.print("enter a number ");
//        int num = sc.nextInt();
//        int p = 0;
//        int n = 1;
//        for(int i = 2; i <= num; i++) {
//            int temp = n;
//            n += p;
//            p = temp;
//        }
//        System.out.println(n);


        //factorial program
//        while(true){
//            int num = sc.nextInt();
//            int fact = 1;
//            if(num < 0){
//                break;
//            } else if ((num == 0) || (num == 1)) {
//                System.out.println(fact);
//            }else {
//                for (int i = 2; i <= num; i++) {
//                    fact *= i;
//                }
//                System.out.println(fact);
//            }
//        }

        //digit repetition
//        System.out.print("Enter the number ");
//        int num = sc.nextInt();
//        System.out.print("Enter the digit ");
//        int dig = sc.nextInt();
//        int count = 0;
//        while(num > 0){
//            int rem = num%10;
//            if(rem == dig){
//                count++;
//            }
//            num /= 10;
//        }
//        System.out.println("Count is " + count);

        //reverse
//        System.out.print("Enter a number ");
//        int num = sc.nextInt();
//        int rev = 0;
//        while(num != 0) {
//            int rem = num % 10;
//            rev = (rev * 10) + rem;
//            num /= 10;
//        }
//        System.out.println("the reverse is " + rev);

        //basic calculator
        System.out.print("Enter a number ");
        int num1 = sc.nextInt();
        System.out.print("Enter a number ");
        int num2 = sc.nextInt();
        System.out.print("Enter an operator ");
        char op = sc.next().trim().charAt(0);
        switch (op) {
            case '+' -> System.out.println(num1 + num2);
            case '-' -> System.out.println(num1 - num2);
            case '*' -> System.out.println(num1 * num2);
            case '/' -> System.out.println(num1 / num2);
            case '%' -> System.out.println(num1 % num2);
            default -> System.out.println("Enter valid operator");
        }

    }
}