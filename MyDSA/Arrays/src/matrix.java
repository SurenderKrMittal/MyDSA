import java.util.*;

public class matrix {
    public static void main(String[] args) {

        int[][] matrix = {
            {1 , 2 , 3 , 4}, 
            {5 , 6 , 7 , 10},
            {8 , 9 , 11 , 12}
        };
        
        transpose(matrix);
    }

    public static int[][] create_matrix(int n , int m) {
        int[][] matrix = new int[n][m];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    } 

    public static void print_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) { // col size can be different for each row
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int largestno(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max , matrix[i][j]);
            }
        }
        return max;
    }

    public static int smallestno(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                min = Math.min(min , matrix[i][j]);
            }
        }
        return min;
    }

    public static void spiral_matrix(int[][] matrix) {
        int startRow = 0;
        int endRow =  matrix.length - 1;
        int startCol = 0;
        int endCol =  matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {

            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow ++;
            startCol ++;
            endCol --;
            endRow --;

        }
    }

    public static int diagnol_sum_brute(int[][] matrix) {
        int sum = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                if(i == j) {
                    sum += matrix[i][j];
                } 
                else if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static int diagnol_sum_optimised(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];

            if (i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static void staircase_search_sorted_matrix (int[][] matrix , int key) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length ) {
            if (key == matrix[row][col]) {
                System.out.println("(" + row + "," + col + ")");
                break;
            } else if (key > matrix[row][col]) {
                col++;
            } else {
                row --;
            }
        }

    }

    public static int searchnumber(int[][] matrix , int num) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == num) {
                        count ++;
                }
            }
        }
        return count;   
    }

    public static int sumofrowelement(int[][] matrix , int row) {
        int sum = 0;
        for(int j = 0; j < matrix[row].length; j++) {
            sum += matrix[row][j];
        }
        return sum;
    }
    
    public static void transpose(int[][] matrix) {
        int[][] new_matrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                new_matrix[j][i] = matrix[i][j];
            }
        }
        print_matrix(new_matrix);
    }
}
