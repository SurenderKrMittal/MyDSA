package Recursion_questions;

import java.util.ArrayList;

public class Permutation_ques {

    // print all permutation of a string
    static void ques(String p ,String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i , p.length());
            ques(f + ch + l, up.substring(1));
        }
    }

    // store all permutations in arraylist
    static ArrayList<String> ques_a(String p ,String up) {
        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> list = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i , p.length());
            list.addAll(ques_a(f + ch + l, up.substring(1)));
        }
        return list;
    }

    // count the number of permutations 
    static int ques_count(String p , String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i , p.length());
            count += ques_count(f + ch + s, up.substring(1));            
        } 
        return count;
    }

    // count the number of permutations taking count in argument 
    static int ques_counta(String p , String up , Integer count) {
        if (up.isEmpty()) {
            count++;
            return count;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i , p.length());
            count = ques_counta(f + ch + s, up.substring(1) , count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(ques_counta("", "abcd" , 0));
    }
}
