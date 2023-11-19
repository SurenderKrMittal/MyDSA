import java.util.ArrayList;
import java.util.Collections;

public class Easy {

    // print reverse of an arraylist
    static void reverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    // find maximum number
    static int max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }

    // swap 2 numbers
    static void swap(ArrayList<Integer> list , int a , int b) {
        int temp = list.get(a);
        list.set(a , list.get(b));
        list.set(b , temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        swap(list, 1, 3);

        // asc sort
        Collections.sort(list);
        System.out.println(list);

        // desc sort
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
