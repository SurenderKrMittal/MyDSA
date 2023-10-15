import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 0};
        System.out.print(missingNumber(nums));
    }

    public static void cyclic(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] < n && i != nums[i]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (j != nums[j]) {
                return j;
            }
        }
        return n;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]){
                swap(nums , i , correct);
            } else {
                i ++;
            }
        }
        int number = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                number = nums[j];
            }
        }
        return number;
    }

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums , i , correct);
            } else {
                i ++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    public int[] set_mismatch(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i , correct);
            } else {
                i ++;
            }
        }
        int[] arr = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                arr[0] = nums[j];
                arr[1] = j + 1;
            }
        }
        return arr;
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {
                swap(nums , i , correct);
            } else{
                i ++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

}

