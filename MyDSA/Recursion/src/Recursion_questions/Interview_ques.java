package Recursion_questions;

import java.util.ArrayList;

public class Interview_ques {

    //for a modified version of problem
    static void ways(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            ways(p + ch, up.substring(1));
        }
    }

    // via arraylist
    static ArrayList<String> waysa(String p ,String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            ArrayList<String> list1 = waysa(p + ch, up.substring(1));
            ans.addAll(list1);
        }
        return ans;
    }

    // get the possible combinations to get target via dice
    static void dice(String p , int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1;i <= target &&  i < 7; i++) {
            dice(p + i, target - i);
        }
    }

   // get the possible combinations to get target via dice via arraylist
    static ArrayList<String> dicea(String p , int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1;i <= target &&  i < 7; i++) {
            ans.addAll(dicea(p + i, target - i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(dicea("", 4));
        dice("", 4);
    }
}
