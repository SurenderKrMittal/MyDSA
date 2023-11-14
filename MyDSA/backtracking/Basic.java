package MyDSA.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Basic {

    static void change_array(int[] arr , int i) {
        if (i == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[i] = i + 1;
        change_array(arr, i + 1);
        arr[i] -= 2; // backtracking step
    }

    // grid ways problem variations
    
    // count the number of ways to reach destination in nxn matrix
    static int count_ways(int r , int c) {
        if (c == 1 || r == 1) {
            return 1;
        }
        int down = count_ways(r - 1, c);
        int right = count_ways(r, c - 1);
        return down + right;
    }
    
    // print the ways to reach destination
    static void print_ways(String p , int r , int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
        }
        if (r > 1) {
            print_ways(p + 'd', r - 1, c);
        }
        if (c > 1) {
            print_ways(p + 'r', r, c - 1);
        }
    }

    // print the ways to reach destination
    static ArrayList<String> return_ways(String p , int r , int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(return_ways(p + 'd', r - 1, c));
        }
        if (c > 1) {
            list.addAll(return_ways(p + 'r', r, c - 1));
        }
        return list;
    }

    // if you can also move diagonaly
    static ArrayList<String> return_ways1(String p , int r , int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(return_ways1(p + 'd', r - 1, c));
        }
        if (r > 1 && c > 1) {
            list.addAll(return_ways1(p + 'D', r - 1, c - 1));
        }
        if (c > 1) {
            list.addAll(return_ways1(p + 'r', r, c - 1));
        }
        return list;
    }

    // if there are maze with obstacles
     static void print_obs_ways(boolean[][] maze , String p , int r , int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (maze[r][c] == false) {
            return;
        }
        if (r < maze.length - 1) {
            print_obs_ways(maze , p + 'd', r + 1, c);
        }
        if (c < maze[0].length - 1) {
            print_obs_ways(maze , p + 'r', r, c + 1);
        }
    }

    // backtracking problem of stack overflow
    static void print_all_ways(boolean[][] maze , String p , int r , int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (maze[r][c] == false) {
            return;
        }
        maze[r][c] = false;
        if (r < maze.length - 1) {
            print_all_ways(maze , p + 'd', r + 1, c);
        }
        if (c < maze[0].length - 1) {
            print_all_ways(maze , p + 'r', r, c + 1);
        }
        if (r > 0) {
            print_all_ways(maze , p + 'u', r - 1, c);
        }
         if (c > 0) {
            print_all_ways(maze , p + 'l', r, c - 1);
        }
        maze[r][c] = true; // reverse the changes that the recursion call made in matrix
    }

    // print the matrix along with path
    static void print_all_ways_matrix(boolean[][] maze , String p , int r , int c , int[][] matrix , int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            matrix[r][c] = step;
            for (int i = 0 ; i < matrix.length ; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (maze[r][c] == false) {
            return;
        }
        maze[r][c] = false;
        matrix[r][c] = step;
        if (r < maze.length - 1) {
            print_all_ways_matrix(maze , p + 'd', r + 1, c , matrix , step + 1);
        }
        if (c < maze[0].length - 1) {
            print_all_ways_matrix(maze , p + 'r', r, c + 1 , matrix , step + 1);
        }
        if (r > 0) {
            print_all_ways_matrix(maze , p + 'u', r - 1, c, matrix , step + 1);
        }
         if (c > 0) {
            print_all_ways_matrix(maze , p + 'l', r, c - 1, matrix , step + 1);
        }
        maze[r][c] = true;
        matrix[r][c] = 0;
    }

    public static void main(String[] args) {
        // int[] arr = new int[5];
        // change_array(arr, 0);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(count_ways(3 , 3));
        boolean[][] arr = {
            {true, true , true},
                {true, true , true},
                {true , true , true}
        };
        int[][] matrix = new int[3][3];
        print_all_ways_matrix(arr ,"", 0, 0 , matrix , 1);
    }
}
