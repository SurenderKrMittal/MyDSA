import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        // add element - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // another add method - O(n)
        list.add(1, 9);

        System.out.println(list);

        // get element - O(1)
        System.out.println(list.get(2));

        // remove element - O(n)
        list.remove(1);
        System.out.println(list);

        // set element at a index - O(n)
        list.set(0, 0);
        System.out.println(list);

        // contains element or not - O(n)
        System.out.println(list.contains(0));
        System.out.println(list.contains(9));
    }
}