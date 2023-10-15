import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);

        String series = "";
        for (int i = 0; i < 26 ; i++) {
            char ch = (char)('a' + i);
            series += (ch + " ");
        }
        System.out.println(series);

        StringBuilder series = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series.append(ch + " ");
        }
        System.out.println(series.toString());
        series.reverse();
        series.deleteCharAt(0);

        System.out.println(series.toString());

        String word = sc.nextLine();
        System.out.println(word.length());
        System.out.println(ispalindrome(word));
    }

    public static boolean ispalindrome(String str) {
        if (str == null) {
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}