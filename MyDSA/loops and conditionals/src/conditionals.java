import java.util.*;

public class conditionals {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // System.out.println("enter a number");
        // int number = input.nextInt();
        // if(number >= 0){
        //     System.out.println("Number is positive");
        // }
        // else{
        //     System.out.println("Number is negative");
        // }
        
        // double temp = 103.5;
        // if(temp > 100.0){
        //     System.out.println("You have a fever");
        // }
        // else{
        //     System.out.println("You don't have a fever");
        // }

        // System.out.println("enter week number(1 - 7)");
        // int number = input.nextInt();
        // switch(number){
        //     case 1 : System.out.println("Monday");
        //                     break;
        //     case 2 : System.out.println("Tuesday");
        //                     break;
        //     case 3 : System.out.println("Wednesday");
        //                     break;
        //     case 4 : System.out.println("Thursday");
        //                     break;
        //     case 5 : System.out.println("Friday");
        //                     break;
        //     case 6 : System.out.println("Saturday");
        //                     break;
        //     case 7 : System.out.println("Sunday");
        //                     break;
        //     default : System.out.println("Wrong number");              
        // }

        //4. false , 63

        // good approach
        System.out.println("Enter year");
        int year = input.nextInt();
        boolean x = (year %4)==0;
        boolean y = (year%100)!=0;
        boolean z = ((year%100 == 0) && (year%400 == 0));
        if(x && (y || z)){
            System.out.println(year + " is a leap year");
        }
        else{
            System.out.println(year + " is not a leap year");
        }


    }
}
