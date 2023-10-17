package Recursion_questions;

public class Strings_ques {

    // if we take another string to store the answer as an argument
    static void skip_char(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            skip_char(p, up.substring(1));
        } 
        else {
            skip_char(p + ch, up.substring(1));
        }
    }

    // if we only take the given string as argument
    static String skip_char(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip_char(up.substring(1));
        } 
        else {
            return ch + skip_char(up.substring(1));
        }
    }

    // skip a string apple
    static String skip_apple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("apple")) {
            return skip_apple(up.substring(5));
        } 
        else {
            return up.charAt(0) + skip_apple(up.substring(1));
        }
    }

    // skip a string app if its not apple
    static String skip_app_not_apple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skip_app_not_apple(up.substring(3));
        } 
        else {
            return up.charAt(0) + skip_app_not_apple(up.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(skip_app_not_apple("acvappladd"));
    }
}
