package MyDSA.backtracking;

import java.util.Arrays;

public class Medium_ques {

    static void print_matrix(char[][] board) {
        System.out.println();
        System.out.println("Chess Board");
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(Arrays.toString(board[i]));
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = row; i >= 0; i--) {  // checking upper vertical part of board
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row , j = col; i >= 0 && j >= 0; i-- , j--) { // checking the upper left diagnol
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row , j = col; i >= 0 && j < board[0].length; i-- , j++) { // checking the upper right diagnol
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // n queen find all possible solution
    static void nQueens(char[][] board , int row) {
        if (row == board.length) {
            print_matrix(board);
            return;
        }
        for (int j = 0; j < board[0].length; j++) {
           if (isSafe(board , row , j)){
             board[row][j] = 'Q';
             nQueens(board, row + 1);
             board[row][j] = 'x';
           }
        }
    }

    static int count = 0;  // n queen find no of possible solution
    static void nQueens1(char[][] board , int row) {
        if (row == board.length) {
            count++;
            return ;
        }
        for (int j = 0; j < board[0].length; j++) {
           if (isSafe(board , row , j)){
             board[row][j] = 'Q';
             nQueens1(board, row + 1);
             board[row][j] = 'x';
           }
        }
    }

    // n queen find if there exists a soluton and print 1
    static boolean nQueens2(char[][] board , int row) {
        if (row == board.length) {
            return true;
        }
        for (int j = 0; j < board[0].length; j++) {
           if (isSafe(board , row , j)){
             board[row][j] = 'Q';
             if(nQueens2(board, row + 1)){
                return true;
             }
             board[row][j] = 'x';
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'x';
            }
        }
        if(nQueens2(board, 0)){
            System.out.println("Solution Exists");
            print_matrix(board);
        }else{
            System.out.println("No Solution Exists");
        }
    }
}
