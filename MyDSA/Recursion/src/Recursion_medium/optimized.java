package Recursion_medium;

public class optimized {

    public static int powerofx(int x , int n) {
        if (n == 0){
            return 1;
        }
        int previos = powerofx(x, n - 1);
        return x * previos;
    }

    public static int optimized_powerofx(int x , int n) {
        if (n == 0){
            return 1;
        }
        int halfpower = optimized_powerofx(x, n/2);
        int halfpowersqr = halfpower * halfpower;
        if (n % 2 != 0) {
            halfpowersqr = x * halfpowersqr;
        }
        return halfpowersqr;
    }

    public static int tiling_problem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int fnm1 = tiling_problem(n - 1);
        int fnm2 = tiling_problem(n - 2);
        int total_ways = fnm1 + fnm2;
        return total_ways;

        // or
        // return tiling_problem(n - 1) + tiling_problem(n - 2);
    }

    public static void remove_duplicates(String str , StringBuilder newstr , int indx , boolean[] map) {
        if (indx == str.length()) {
            System.out.println(newstr);
            return;
        }
        char current_char = str.charAt(indx);   
        if (map[current_char - 'a'] == true) {
            remove_duplicates(str, newstr, indx + 1, map);
        } else {
            map[current_char - 'a'] = true;
            newstr.append(current_char);
            remove_duplicates(str, newstr, indx + 1, map);
        }
    }

    public static int friends_pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int fnm1 = friends_pairing(n - 1);
        int fnm2 = friends_pairing(n - 2);
        int ways = (n - 1) * fnm2;
        return fnm1 + ways;

        //or
        // return friends_pairing(n - 1) + (n - 1) * friends_pairing(n - 2);
    }

    public static void printbinstrings(int n , int lastplace , String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printbinstrings(n - 1, 0, str + '0');
        if (lastplace == 0) {
            printbinstrings(n - 1, 1, str + '1');
        }
    }

    public static int binary_search_optimised(int[] arr , int key , int start , int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] < key) {
            return binary_search_optimised(arr , key , mid + 1 , end);
        }
        return binary_search_optimised(arr, key, start, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 66 , 80 , 94};
        int ans = binary_search_optimised(arr , 5 , 0 , arr.length - 1);
        System.out.println(ans);
    }
}
