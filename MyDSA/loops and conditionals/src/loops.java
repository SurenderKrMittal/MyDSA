import java.util.*;

public class loops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //1. 2

        // System.out.println("Enter the total number of integers");
        // int number = input.nextInt();
        // int evensum = 0;
        // int oddsum = 0;
        // for(int i = 1; i <= number; i++) {
        //     System.out.println("Enter the integer");
        //     int choice = input.nextInt();
        //     if((choice % 2) == 0) {
        //         evensum += choice;
        //     }else{
        //         oddsum += choice;
        //     }
        // }
        // System.out.println("Sum of even integers is : " + evensum);
        // System.out.println("Sum of odd integers is : " + oddsum);

        // System.out.println("Enter the number");
        // int number = input.nextInt();
        // if(number < 0) {
        //     System.out.println("Negative numbers do not have facorials");
        // } 
        // else if(number == 0) {
        //     System.out.println("Facorial is : " + 1);
        // }
        // else{
        //     int i = 1;
        //     int fact = 1;
        //     while(i <= number) {
        //         fact *= i;
        //         i++;
        //     }
        //     System.out.println("Factorial is : " + fact);
        // }

        // System.out.println("Enter the number ");
        // int num = input.nextInt();
        // for(int i = 1; i <= 10; i++) {
        //     System.out.println(num + "x" + i + "=" + num*i);
        // }

        //5. i is only applicable inside loop

        //prime number
        int num = input.nextInt();
        int i = 2;
        int flag = 1;
        while(i <= Math.sqrt(num)){
            if (num % i == 0){
                flag = 0;
                break; 
            }
            i++;
        }
        if(flag == 1){
            System.out.print("" + num +" is a prime no.");
        }else{
            System.out.print("" + num + "is not a prime no.");
        }
        

    }
}
