import java.util.*;

public class basic_sorting {

    public static void swap(int[] arr, int first , int second) {
        int temp = arr[first];
        arr[first]  =   arr [second ];
        arr[second ]=temp;
    }

   public static void bubble(int[] arr)  {
        boolean count = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j + 1]) {
                    swap(arr , j , j + 1);
                    count = true;
                }
            }
            if(!count) {
                break;
            }
        }
    }
    
    public static int getminindex(int[] arr , int start , int end) {
        int min = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int min = getminindex(arr , 0 , last);

            swap(arr , min , last );
        }
    }

    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(arr[j] > arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void counting(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }
        int j = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};

        counting(nums);
        System.out.print(Arrays.toString(nums));

    }
}
