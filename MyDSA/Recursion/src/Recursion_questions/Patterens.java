package Recursion_questions;

public class Patterens {


    static void triangle1(int r , int c) {
        if (r < 0){
            return;
        }
        if (c > r) {
            System.out.println();
            triangle1(r - 1, 0);
       }else {
            System.out.print("* "); 
            triangle1(r, c + 1);
       }   
    }

    static void triangle2(int r , int c) {
        if (r < 0){
            return;
        }
        if (c > r) {
            triangle2(r - 1, 0);
            System.out.println();
       }else {
            triangle2(r, c + 1);
            System.out.print("* "); 
       }   
    }

    public static void main(String[] args) {
        triangle2(3 , 0);
    }
}
