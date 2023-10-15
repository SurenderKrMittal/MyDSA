import java.util.Arrays;

public class Main {
    public static void row_col_arr(int[][] matrix , int num) {
        int row = 0;
        int col = matrix[row].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < num) {
                row ++;
            } else if (matrix[row][col] > num) {
                col --;
            } else {
                System.out.println("(" + row + "," + col + ")");
                break;
            }
        }
    }

    public static int[] binary_search(int[][] matrix , int target , int row , int start_col , int end_col) {
        while (start_col <= end_col) {
            int mid = start_col + (end_col - start_col) / 2;
            if(matrix[row][mid] > target) {
                end_col = mid - 1;
            } else if (matrix[row][mid] < target) {
                start_col = mid + 1;
            } else {
                return new int[] {row,mid};
            }
        }
        return new int[] {-1 , -1};
    }

    public static int[] search_sorted_matrix(int[][] matrix , int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1) {
            return binary_search(matrix , target , 0 , 0 , cols - 1);
        }

        int start_row = 0;
        int end_row = rows - 1;
        int mid_col = cols / 2;

        while (start_row < (end_row - 1)) {
            int mid_row = start_row + (end_row - start_row) / 2;
            if (target < matrix[mid_row][mid_col]) {
                end_row = mid_row;
            } else if (target > matrix[mid_row][mid_col]) {
                start_row = mid_row;
            } else {
                return new int[] {mid_row , mid_col};
            }
        }

        if (target == matrix[start_row][mid_col]) {
            return new int[] {start_row , mid_col};
        }
        if (target == matrix[start_row + 1][mid_col]) {
            return new int[] {start_row + 1, mid_col};
        }

        if (target <= matrix[start_row][mid_col - 1]) {
            return binary_search(matrix , target , start_row , 0 , mid_col - 1);
        }
        if (target >= matrix[start_row][mid_col + 1] && target <= matrix[start_row][cols - 1]) {
            return binary_search(matrix , target , start_row , mid_col + 1 , cols - 1);
        }
        if (target <= matrix[start_row + 1][mid_col - 1]) {
            return binary_search(matrix , target , start_row + 1 , 0 , mid_col - 1);
        }
         else {
            return binary_search(matrix , target , start_row + 1 , mid_col + 1 , cols - 1);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1 , 2 , 3 },
                {4 , 5 , 6 },
                {7 , 8 , 9 },
        };
        System.out.println(Arrays.toString(search_sorted_matrix(matrix , 5)));
    }
}
