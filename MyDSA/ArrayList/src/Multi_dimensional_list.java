import java.util.ArrayList;
import java.util.Scanner;

public class Multi_dimensional_list {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // adding the elements in arraylists
        // for (int i = 1; i <= 5; i++) {
        //     list1.add(1 * i);
        //     list2.add(2 * i);
        //     list3.add(3 * i);
        // }

        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // list2.remove(2);
        // list2.remove(3);

        // another way to add elements
        for (int i = 0; i < 3; i++) {
            mainList.add(new ArrayList<Integer>());
        }

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mainList.get(i).add(in.nextInt());
            }
        }

        // printing the arraylist 
        System.out.println(mainList);

        // printing the 2d arraylist as matrix
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> list = mainList.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            } 
            System.out.println();
        }
    }
}
