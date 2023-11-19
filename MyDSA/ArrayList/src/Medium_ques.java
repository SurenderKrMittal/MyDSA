import java.util.ArrayList;

public class Medium_ques {

    static int most_water(ArrayList<Integer> height) {
        int max_water = Integer.MIN_VALUE;
        for (int i = 0; i < height.size() - 1; i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int width = j - i;
                int min_height = Math.min(height.get(i), height.get(j));
                int water = width * min_height;
                max_water = Math.max(max_water, water);
            }
        }
        return max_water;
    }

    // two pointer method
    static int most_water_1(ArrayList<Integer> height) {
        int max_water = Integer.MIN_VALUE;
        int left_pointer = 0;
        int right_pointer = height.size() - 1;
        while (left_pointer < right_pointer) {
            int width = right_pointer - left_pointer;
            int min_height = Math.min(height.get(left_pointer), height.get(right_pointer));
            int water = width * min_height;
            max_water = Math.max(max_water, water);
            if (height.get(left_pointer) < height.get(right_pointer)) {
                left_pointer ++;
            } else {
                right_pointer --;
            }
        }
        return max_water;
    }

    // Pair sum 1
    // brute force approach
    static boolean pair_sum_1b(ArrayList<Integer> list , int target) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // pair sum 1
    // 2 pointer approach
    static boolean pair_sum_1p(ArrayList<Integer> list , int target) {
        int left_pointer = 0;
        int right_pointer = list.size() - 1;
        while (left_pointer < right_pointer) {
            if (list.get(right_pointer) + list.get(left_pointer) == target) {
                return true;
            }
            if (list.get(right_pointer) + list.get(left_pointer) < target) {
                left_pointer ++;
            }
            else {
                right_pointer --;
            }
        }
        return false;
    }

    // pair sum 2
    // 2 pointer method
    static boolean pair_sum_2p(ArrayList<Integer> list , int target){
        int pivot_indx = 0;
        // complexity of while loop is O(n) thats why binary search approach is not used to find pivot indx
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot_indx = i;
                break;
            }
        }
        int left_pointer = pivot_indx + 1;
        int right_pointer = pivot_indx;
        while (left_pointer != right_pointer){
            if (list.get(left_pointer) + list.get(right_pointer) == target) {
                return true;
            }
            if (list.get(left_pointer) + list.get(right_pointer) < target) {
                left_pointer = (left_pointer + 1) % list.size();
            } else {
                right_pointer = (list.size() + right_pointer - 1) % list.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1 8 6 2 5 4 8 3 7
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        
        System.out.println(pair_sum_2p(height, 2));
    }
}
