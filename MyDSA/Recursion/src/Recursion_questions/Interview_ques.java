package Recursion_questions;

import java.util.ArrayList;

public class Interview_ques {

    //for a modified version of problem number of letter combination of a phone number
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

    // letter combination of a phone number leetcode
    // arraylist in body
    static ArrayList<String> letterCombinations(String p , String up) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> ans = new ArrayList<>();
        if (digit == 1) {
            ans.addAll(letterCombinations(p, up.substring(1)));
        }
        else if (digit == 7) {
           for (int i = ((digit - 1) * 2) + (digit - 3); i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                ans.addAll(letterCombinations(p + ch, up.substring(1)));
            }
        }
         else if (digit == 8) {
           for (int i = ((digit - 1) * 2) + (digit - 3) + 1; i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                ans.addAll(letterCombinations(p + ch, up.substring(1)));
            }
        }
        else if (digit == 9) {
           for (int i = ((digit - 1) * 2) + (digit - 3) + 1; i <= ((digit - 1) * 3) + 2; i++) {
                char ch = (char)('a' + (i - 1));
                ans.addAll(letterCombinations(p + ch, up.substring(1)));
            }
        }
        else{
            for (int i = ((digit - 1) * 2) + (digit - 3); i < ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                ans.addAll(letterCombinations(p + ch, up.substring(1)));
            }
        }
        return ans; 
    }

    // taking arraylist in argument
    static ArrayList<String> letterCombinations(String p , String up ,  ArrayList<String> list) {
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        if (digit == 1) {
            letterCombinations(p, up.substring(1) , list);
        }
        else if (digit == 7) {
           for (int i = ((digit - 1) * 2) + (digit - 3); i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                letterCombinations(p + ch, up.substring(1) , list);
            }
        }
        else if (digit == 8) {
           for (int i = ((digit - 1) * 2) + (digit - 3) + 1; i <= ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                letterCombinations(p + ch, up.substring(1) , list);
            }
        }
        else if (digit == 9) {
           for (int i = ((digit - 1) * 2) + (digit - 3) + 1; i <= ((digit - 1) * 3) + 2; i++) {
                char ch = (char)('a' + (i - 1));
                letterCombinations(p + ch, up.substring(1) , list);
            }
        }
        else {
            for (int i = ((digit - 1) * 2) + (digit - 3); i < ((digit - 1) * 3) + 1; i++) {
                char ch = (char)('a' + (i - 1));
                letterCombinations(p + ch, up.substring(1) , list);
            }
        }
        
        return list;
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
        System.out.println(letterCombinations("", "23"));
        // dice("", 4);
    }
}
