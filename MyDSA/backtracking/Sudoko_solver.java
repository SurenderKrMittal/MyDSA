package MyDSA.backtracking;

import java.util.Arrays;

public class Sudoko_solver {

    static void print_matrix(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(Arrays.toString(board[i]));
            System.out.println();
        }
    }

    static boolean isSafe(int[][] suduko , int row , int col , int digit){
        for (int i = 0; i < 9; i++) { // checking the row
            if (suduko[row][i] == digit) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) { // checking the column
            if (suduko[j][col] == digit) {
                return false;
            }
        }

        //check the grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (suduko[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solver(int[][] suduko , int row , int col) {
        if (row == 9) {
            return true;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (suduko[row][col] != 0) {
            return solver(suduko, nextRow, nextCol);
        }
        for (int digit = 1; digit < 10; digit++) {
            if (isSafe(suduko , row , col , digit)) {
                suduko[row][col] = digit;
                if(solver(suduko, nextRow, nextCol)){
                    return true;
                }
                suduko[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] suduko = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        if (solver(suduko, 0, 0)) {
            System.out.println("Solution exists");
            print_matrix(suduko);
        } else{
            System.out.println("No solution exists");
        }
    }
}
