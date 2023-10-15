import java.util.*;

public class JavaBasics{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextFloat();
        float pen = sc.nextFloat();
        float eraser = sc.nextFloat();
        float sum = pencil + pen + eraser;
        float cost = sum + ((18 * sum)/100);
        System.out.println("Cost is : " + cost);
    }
}