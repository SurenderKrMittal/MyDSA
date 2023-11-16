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
        for (int i = row - 1; i >= 0; i--) {  // checking upper vertical part of board
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i-- , j--) { // checking the upper left diagnol
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i-- , j++) { // checking the upper right diagnol
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

    static boolean isSafe1 (char[][] board , int row , int col) { // checks for moves of knight(ghoda)
        if(isValid(board, row - 2, col - 1)){
            if (board[row - 2][col - 1] == 'K'){ 
                return false;
            }
        }
        if(isValid(board, row - 2, col + 1)){
            if (board[row - 2][col + 1] == 'K'){ 
                return false;
            }
        }
        if(isValid(board, row - 1, col - 2)){
            if (board[row - 1][col - 2] == 'K'){ 
                return false;
            }
        }
        if(isValid(board, row - 1, col + 2)){
            if (board[row - 1][col + 2] == 'K'){ 
                return false;
            }
        }
        return true;
    }

    static boolean isValid(char[][] board , int row , int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }

    // n knights problem
    static void nKnights(char[][] board , int row , int col , int knights) {
        if (knights == 0) {
            print_matrix(board);
            return;
        }
        if (row == board.length) {
            return;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == board.length) {
            nextRow ++;
            nextCol = 0;
        }  
        if(isSafe1(board , row , col)) {
            board[row][col] = 'K';
            nKnights(board, nextRow, nextCol, knights - 1);
            board[row][col] = 'X';
        }
        nKnights(board, nextRow, nextCol, knights);
    }

    // n knights problem count the nuber of solution
    static int count_knight = 0;
    static void nKnights_count(char[][] board , int row , int col , int knights) {
        if (knights == 0) {
            count_knight++;
            return;
        }
        if (row == board.length) {
            return;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == board.length) {
            nextRow ++;
            nextCol = 0;
        }  
        if(isSafe1(board , row , col)) {
            board[row][col] = 'K';
            nKnights_count(board, nextRow, nextCol, knights - 1);
            board[row][col] = 'X';
        }
        nKnights_count(board, nextRow, nextCol, knights);
    }

    static boolean isSafe_tour (int[][] board , int row , int col) {
        if (isValid_tour(board, row, col)) {
            if (board[row][col] != 0) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid_tour(int[][] board , int row , int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length){
            return true;
        }
        return false;
    }

    // knight's tour
    static boolean tour(int[][] board , int row , int col) {
        if (!((isSafe_tour(board , row + 2, col + 1)) || (isSafe_tour(board , row + 2, col - 1)) || (isSafe_tour(board , row + 1, col + 2)) || (isSafe_tour(board , row - 1, col + 2)) || (isSafe_tour(board , row - 2, col + 1)) || (isSafe_tour(board , row - 2, col - 1)) || (isSafe_tour(board , row - 1, col - 2)) || (isSafe_tour(board , row - 2, col + 1)))) {
             System.out.println("( " + row + " , " + col + " )");
            return true;
        }
        if (board[row][col] == 0) {
            return false;
        }
        System.out.println("( " + row + " , " + col + " )");
        board[row][col] = 0;
        if (isSafe_tour(board , row + 2, col + 1)) { // down
            return tour(board, row + 2, col + 1);
        }
        if (isSafe_tour(board , row + 2, col - 1)) { // down
            return tour(board, row + 2, col - 1);
        }
        if (isSafe_tour(board , row + 1, col + 2)) { // right
            return tour(board, row + 1, col + 2);
        }
        if (isSafe_tour(board , row - 1, col + 2)) { // right
            return tour(board, row - 1, col + 2);
        }
        if (isSafe_tour(board , row - 2, col + 1)) { // up
            return tour(board, row - 2, col + 1);
        }
        if (isSafe_tour(board , row - 2, col - 1)) { // up
            return tour(board, row - 2, col - 1);
        }
        if (isSafe_tour(board , row - 1, col - 2)) { // left
            return tour(board, row - 1, col - 2);
        }
        if (isSafe_tour(board , row - 2, col + 1)) { // left
            return tour(board, row - 2, col + 1);
        }
        board[row][col] = 1;
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 1;
            }
        }
        // nKnights(board, 0 , 0 , n);
        // nKnights_count(board, 0, 0, n);
        // System.out.println("Number of solutions : " + count_knight);
        tour(board, 0, 0);
    }
}
