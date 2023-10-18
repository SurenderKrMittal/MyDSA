package Recursion_questions;

import java.util.ArrayList;

public class Subsequences {

    // print all possible subsets of a string
    static void all_subseq(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        all_subseq(p + ch, up.substring(1));
        all_subseq(p, up.substring(1));
    }

    // store all possible subsets of a string in arraylist taking arraylist static
    static ArrayList<String> s = new ArrayList<>();
    static void all_subseq_list_1(String p , String up) {
        if (up.isEmpty()) {
            s.add(p);
            return;
        }
        char ch = up.charAt(0);
        all_subseq_list_1(p + ch, up.substring(1));
        all_subseq_list_1(p, up.substring(1));
    }

    // store all possible subsets of a string in arraylist taking arraylist as argument
    static ArrayList<String> all_subseq_list_2(String p , String up , ArrayList<String> a) {
        if (up.isEmpty()) {
            a.add(p);
            return a;
        }
        char ch = up.charAt(0);
        all_subseq_list_2(p + ch, up.substring(1) , a);
        all_subseq_list_2(p, up.substring(1) , a);
        return a;
    }

    // store all possible subsets of a string in arraylist
    static ArrayList<String> all_subseq_list(String p , String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = all_subseq_list(p + ch, up.substring(1));
        ArrayList<String> right = all_subseq_list(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    // print all possible subsets of a string with ascii
    static void all_subseq_ascii(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        all_subseq_ascii(p + ch, up.substring(1));
        all_subseq_ascii(p + (ch + 0), up.substring(1));
        all_subseq_ascii(p, up.substring(1));
    }

    // store all possible subsets of a string in arraylist
    static ArrayList<String> all_subseq_list_ascii(String p , String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = all_subseq_list_ascii(p + ch, up.substring(1));
        ArrayList<String> second = all_subseq_list_ascii(p, up.substring(1));
        ArrayList<String> third = all_subseq_list_ascii(p + (ch + 0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }

    public static void main(String[] args) {
        //System.out.println(all_subseq_list_ascii("","abcd"));
        // all_subseq_ascii("","abcd");\
        ArrayList<String> i = new ArrayList<>();
        System.out.println(all_subseq_list_2("", "abc" , i));
    }
}
