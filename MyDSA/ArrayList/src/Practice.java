import java.util.ArrayList;
import java.util.Collections;

public class Practice {

    // monotonic arraylist (monotone increasing or monotone decreasing)
    static boolean monotonic(ArrayList<Integer> list) {

        // checking if the arraylist should be considered ascending 
        if (list.get(0) <= list.get(list.size() - 1)) {

            // if list should be ascending 
            for (int i = 0; i < list.size() - 1; i++) {
                if ((list.get(i)) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
        
        // if list should be desc
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i)) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // lonely numbers
    // bruteforce
    static void lonely (ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == list.get(i) - 1 || list.get(j) == list.get(i) + 1 || list.get(j) == list.get(i)) {
                    list.remove(j); // first remove j cuz if we remove i first the indx of value at j would change
                    list.remove(i);
                }
            }
        }
        System.out.println(list);
    }

    // lonely numbers
    // optimised solution
    static void lonely_o(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        // this will find lonely numbers from indx 1 to n - 2 
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i + 1) - 1 > nums.get(i)) {
                list.add(nums.get(i));
            }
        }
       
        // this will find if first and last numbers in list are lonely or not
        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }
    }

    // most frequent number following key
    // bruteforce 
    static int most_frequent(ArrayList<Integer> list , int key) {
        int max_count = -1;
        int ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int target = list.get(i);
            int count = 0;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) == target) {
                    if (list.get(j - 1) == key) {
                        count ++;
                    }
                }
            }
            if (count > max_count) {
                ans = target;
                max_count = count;
            }
        }
        return ans;
    }

    // optimised solution
    static int most_frequent_optimised(ArrayList<Integer> list , int key) {
        int[] result = new int[1000];

        // every indx in result array that is a target in list will contain the count of its appearance after the key
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                result[list.get(i + 1)]++;
            }
        }
        int ans = -1;
        int count = 0;
        
        // find the indx of array with the largest value as that is the answer
        for (int i = 0; i < result.length; i++) {
            if (result[i] > count) {
                count = result[i];
                ans = i;
            }
        }
        return ans;
    }

    // beautiful arraylist
    static ArrayList<Integer> beautiful(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer integer : ans) {
                if (integer * 2 <= n) {
                    temp.add(integer * 2);
                }
            }
            for (Integer integer : ans) {
                if ((integer * 2) - 1 <= n) {
                    temp.add((integer * 2) - 1);
                }
            }
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        
        System.out.println(beautiful(10));
        
    }
}
