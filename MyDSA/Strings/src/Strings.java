import java.util.*;

public class Strings {

    public static boolean is_palindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
            return false;
            }
        }
        return true;
    }

    public static float shortest_path(String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'S') {
                y--;
            } else if (str.charAt(i) == 'W') {
                x--;
            } else if (str.charAt(i) == 'E') {
                x++;
            }
        }
        x = (int)(Math.pow(x , 2));
        y = (int)(Math.pow(y , 2));
        float ans = (float) (Math.sqrt(x + y));
        return ans;
    }

    public static String substring(String str , int start , int end) {
        String ans = new String();
        for (int i = start; i < end; i++) {
            ans += str.charAt(i);
        }
        return ans;
        // alternative is inbuilt substring function
    }

    public static String largest(String str[]) {
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (largest.compareToIgnoreCase(str[i]) < 0) {
                largest = str[i];
            }
        }
        return largest;
    }

    public static String touppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count ++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static int lower_case_vowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' ) {
                count ++;
            }
        }
        return count;
    }

    // ques 2 false true

    // ques 3 ApnaCoege

    public static boolean anagram (String word1 , String word2) {
        String str1 = word1.toLowerCase();
        String str2 = word2.toLowerCase();
        if (str1.length() == str2.length()) {
            char[] arr = str1.toCharArray();
            for (int i = 0; i < str2.length(); i++) {
                char ch = str2.charAt(i);
                boolean flag = false;
                for (int j = 0; j < arr.length; j++) {
                    if (ch == arr[j]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean anagram_optimesed (String word1 , String word2) {
        String str1 = word1.toLowerCase();
        String str2 = word2.toLowerCase();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        if (arr1.length == arr2.length) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                } 
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(anagram_optimesed(str1 , str2));
    }
}
