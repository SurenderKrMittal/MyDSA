import java.lang.instrument.IllegalClassFormatException;
import java.util.*;

public class Arrays{

    public static void update_marks(int[] arr ){
        for (int i = 0; i < arr.length; i++) {
            arr[i] ++;
        }
    }

    public static void print_array(int[] array) {
        for( int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
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
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
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
        return array.length;
    }

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start ++;
            end--;
        }
        print_array(arr);
    }

    public static void pairs(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void subarrays(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for( int j = i; j < arr.length; j++){
                for(int k = i; k <= j ; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void maxsum_subarrays(int[] arr) {
        int maxsum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int sum = 0;
                for(int k = i; k <= j ; k++) {
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                if(sum > maxsum) {
                    maxsum = sum;
                }
                if(sum < minsum) {
                    minsum = sum;
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("The maximum sum of subarrays is " + maxsum);
        System.out.println("The minimum sum of subarrays is " + minsum);
    }

    public static void maxsum_prefix(int[] arr) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        int[] prefix_array = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            prefix_array[i] = sum;
        }
        print_array(prefix_array);
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if(i == 0) {
                    sum = prefix_array[j];
                } else {
                    sum = prefix_array[j] - prefix_array[i -1];
                }
                if(maxsum < sum) {
                    maxsum = sum;
                }
            }
        }
        System.out.println("The max sum is " + maxsum);
    }

    public static void maxsum_kadan(int[] arr) {
        boolean flag = false;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0){
                flag = true;
                break;
            }
        }
        if(flag) {
            int sum = 0;
            for(int j = 0; j < arr.length; j++) {
                sum += arr[j];
                if(sum < 0){
                    sum = 0;
                } 
                maxsum = Math.max(maxsum, sum);
            }
        } else {
            maxsum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                maxsum = Math.max(maxsum, arr[i]);
            }
        }
        System.out.println("The max sum is " + maxsum);
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
        for (int i = n - 2; i >= 0; i--) {
            right_max_boundary[i] = Math.max(height[i], right_max_boundary[i + 1]);
        }
        for(int i = 0; i < n; i++) {
            int water_level = Math.min(left_max_boundary[i], right_max_boundary[i]);
            trapped_water += (water_level - height[i]) * width;
        }
        return trapped_water;
    }

    public static int stock(int[] price) {
        int buying_price = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < price.length; i++) {
            if (buying_price < price[i]) {
                int profit = price[i] - buying_price;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buying_price = price[i];
            }
        }
        return maxprofit;
    }

    public static boolean distinct_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(key == arr[j]) {
                    return true;      
                }
            }
        }
        return false;
    }

    public static int ques3(int[] prices) { // same as stock function
        int bp = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++) {
            if (bp < prices[i]) {
                int profit = prices[i] - bp;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                bp = prices[i];
            }
        }
        return maxprofit;
    }

    public static int ques4(int[] height) { // trapped water function
        int trapped_water = 0;
        int n = height.length;
        int width = 1;
        int[] left_max_boundary = new int[n];
        int[] right_max_boundary = new int[n];
        left_max_boundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max_boundary[i] = Math.max(left_max_boundary[i - 1], height[i]);
        }
        right_max_boundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max_boundary[i] = Math.max(right_max_boundary[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            int water_level = Math.min(left_max_boundary[i], right_max_boundary[i]);
            trapped_water += (water_level - height[i]) * width;
        }
        return trapped_water;
    } 

    public static int rotated_binary_search(int[] nums, int target) {
        int pivot = findpivot(nums);
        if (pivot == target) {
            return pivot;
        } else if(target > nums[nums.length - 1]) {
            return asc_binary_search(nums, target, 0, pivot - 1);
        } else {
            return asc_binary_search(nums, target, pivot + 1, nums.length - 1);
        }
    }

    public static int findpivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1] ){
                return mid - 1;
            } else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;   
            } else if(nums[start] > nums[mid]){
                end = mid - 1;
            } else if(nums[start] <= nums[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int asc_binary_search(int[] array , int target , int start , int end) {
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

    public static void main(String[] args){

        int[] numbers = {4,5,6,7,0,1,2};
        System.out.println( rotated_binary_search(numbers , 0) );
    }
}