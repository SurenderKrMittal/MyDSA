import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void update_marks(int[] arr ){
        for (int i = 0; i < arr.length; i++) {
            arr[i] ++;
        }
    }

    public static void print_array(int[] array) {
        for( int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int linear_search(String[] array, String target) {
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int largest(int[] array) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest =  array[i];
            }
        }
        return  largest;
    }

    public static void input(int[] array) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter the elements in array ");
            array[i] = sc.nextInt();
        }
    }

    public static int smallest(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i] , min);
        }
        return min;
    }

    public static int evendigits(int[] arr) {
        int count = 0;
        for (int num: arr) {
            int x = noofdigits(num);
            if(even(x)) {
                count ++;
            }
        }
        return count;
    }

    public static boolean even(int num) {
        if(num < 0) {
            num *= -1;
        }

        return num % 2 == 0;
    }

    public static int noofdigits(int num) {
        int count = 0;
        while(num > 0) {
            count ++;
            num /= 10;
        }
        return count;
    }

    public static boolean search(String str, char target) {
        if( str.length() == 0) {
            return false;
        }
        for (char ch : str.toCharArray() ){
            if (ch == target){
                return true;
            }
        }
        return false;
    }

    public static int searchinrange(int[] arr , int target , int start , int end) {
        if(arr.length == 0) {
            return -1;
        }
        for(int i = start; i <= end; i++) {
            if(target == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int binary_search(int[] array , int target) {
        int start = 0;
        int end = array.length;
        int mid = (start + end) / 2;
        while(start <= end) {
            if (array[mid] > target) {
                end = mid --;
            } else if(array[mid] == target) {
                return mid;
            } else{
                start = mid ++;
            }
        }
        return -1;
    }

    public static int trapped_water(int[] height) {
        int n = height.length;
        int trapped_water = 0;
        int width = 1;
        int[] left_max_boundary = new int[n];
        int[] right_max_boundary = new int[n];
        left_max_boundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max_boundary[i] = Math.max(height[i], left_max_boundary[i - 1]);
        }
        right_max_boundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i++) {
            right_max_boundary[i] = Math.max(height[i], right_max_boundary[i + 1]);
        }
        for(int i = 0; i < n; i++) {
            int water_level = Math.min(left_max_boundary[i], right_max_boundary[i]);
            trapped_water += (water_level - height[i]) * width;
        }
        return trapped_water;
    }

    public int[] buildArray(int[] nums) {
        int [] ans = new int[nums.length];
        for (int i : nums) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int[] getconcotenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < 2 * nums.length ; i++) {
           if(i < nums.length) {
               ans[i] = nums[i];
           } else {
               ans[i] = nums[i - nums.length];
           }
        }
        return ans;
    }

    public int[] runningsum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length;i++) {
            ans[i] = ans[i-1] + nums[i] ;
        }
        return ans;
    }

    public static int[] reverse(int[] arr ,int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
         }
        return arr;
    }

    public static void bubble(int[] arr) {
        boolean count = false;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count = true;
                }
            }
            if(!count) {
                break;
            }
        }
    }

    public static void selection(int[] arr) {
        for(int  i = 0; i < arr.length; i++) {
            int first = i;
            int minindex = getminindex(arr, first, arr.length - 1);

            reverse(arr,minindex,first);
        }
    }

    public static int getminindex(int[] arr,int start, int end) {
        int min = start;
        for(int i = start + 1; i <= end; i++) {
            if(arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int start , int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    reverse(arr, j, j - 1 );
                } else {
                    break;
                }
            }
        }

    }

    public static void countingsort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max , arr[i]);
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                count[i] --;
                j++;
            }
        }
    }

    public static int[] rotate(int[] arr , int k) {
        k = k % arr.length;
        reverse (arr, 0, arr.length - 1);
        reverse (arr , 0 , k - 1);
        reverse (arr , k , arr.length - 1 );
        return arr;
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end  = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start , nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int division = 1;
            for (int j = 0; j < nums.length; j++) {
                if (sum + nums[j] > mid) {
                    division++;
                    sum = nums[j];
                } else {
                    sum += nums[j];
                }
            }

            if (division > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; //or end as both are same
    }

    public static void main(String[] args){

        int[] nums = {7,2,5,10,8};

        System.out.println(splitArray(nums , 2));

    }
}
