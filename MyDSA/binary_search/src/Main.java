import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7};

        System.out.println(rotationcount(nums));
    }

    public static int ceiling(int[] nums , int target) {
        if (target >= nums[nums.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start];
    }

    public static int floor(int[] nums , int target) {
        if (target <= nums[0]) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[end];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start];
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1 , -1};
        arr[0] = search(nums , target , true);
        arr[1] = search(nums, target, false);
        return arr;
    }
    public static int search(int[] nums, int target , boolean searchfirstindex) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if(searchfirstindex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int infinte_array(int[] nums , int target) {
        int start = 0;
        int end = 1;
        while(target > nums[end]) {
            int newstart = end + 1;
            end = end + (end - start) * 2;
            start = newstart;
        }
        return binary_search(nums , target , start , end);
    }

    public static int binary_search(int[] nums,int target, int start , int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int searchinmoutainarray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int ans = orderagnosticbinarysearch(arr , target , 0 , peak);
        if (ans != -1) {
            return ans;
        }
        return orderagnosticbinarysearch(arr , target , peak + 1, arr.length - 1);
    }

    public static int orderagnosticbinarysearch(int[] arr , int target , int start , int end) {
        boolean isasc = true;
        if (arr[start] - arr[end] > 0) {
            isasc = false;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > target) {
                if(isasc) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                if (isasc) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findpivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]){
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int rotated_binary_search(int[] arr , int target) {
        int pivot = findpivot(arr);

        int ans = binary_search(arr , target , 0 , pivot);
        if (ans != -1) {
            return ans;
        }
        return binary_search(arr , target , pivot + 1, arr.length - 1);
    }

    public static int findpivotwithduplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]){
                return mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                if (start < arr.length - 1 && arr[start] > arr[start + 1]) {
                    return start;
                }
                start ++;
                if (end > 0 && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end --;
            } else if (arr[start] > arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int rotationcount(int[] arr) {
        int pivot = findpivot(arr);

        return pivot + 1;
    }


}
