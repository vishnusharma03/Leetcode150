package src;

import java.util.Arrays;

public class Leetcode289 {
    public static void main(String[] args) {

        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        for (int[] ins : board) {
            System.out.println(Arrays.toString(ins));
        }
    }
    // Optimized Method
    private static void gameOfLife(int[][] board) {
        int[][] neighborCount = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==1) {
                    helper(neighborCount, i - 1, j);
                    helper(neighborCount, i, j - 1);
                    helper(neighborCount, i - 1, j - 1);
                    helper(neighborCount, i - 1, j + 1);
                    helper(neighborCount, i + 1, j - 1);
                    helper(neighborCount, i, j + 1);
                    helper(neighborCount, i + 1, j);
                    helper(neighborCount, i + 1, j + 1);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbour = neighborCount[i][j];
                if (neighbour == 3 || (neighbour == 2 && board[i][j] == 1)) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private static void helper(int[][] counts, int i, int j) {
        if(i < 0 || j < 0 || i >= counts.length || j >= counts[0].length){
            return;
        }
        counts[i][j]++;
    }

}


// Brute Force Method

//    private static void gameOfLife(int[][] board) {
//        int[][] result = new int[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                int sum = 0;
//                sum += helper(board, i - 1, j);
//                sum += helper(board, i, j - 1);
//                sum += helper(board, i - 1, j - 1);
//                sum += helper(board, i - 1, j + 1); //x
//                sum += helper(board, i + 1, j - 1);
//                sum += helper(board, i, j + 1);
//                sum += helper(board, i + 1, j); //x
//                sum += helper(board, i + 1, j + 1);
//
//                if (sum == 3 || (sum == 2 && board[i][j] == 1)) {
//                    result[i][j] = 1;
//                } else {
//                    result[i][j] = 0;
//                }
//            }
//        }
//        for(int i = 0; i < board.length; i++){
//            board[i] = result[i].clone();
//        }
//    }
//
//    private static int helper(int[][] board, int i, int j) {
//        try {
//            return board[i][j];
//        } catch (IndexOutOfBoundsException e) {
//            return 0;
//        }
//    }
//}

// Error

//    public static void gameOfLife(int[][] board) {
//        int m = board.length;
//        int n = board[0].length;
//
//        if (m == 1 && n == 1) board[1][1] = 0;
//
//        if (m != n && m == 1 || n == 1) {
//            int[][] conv = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                Arrays.fill(conv[i], 1);
//            }
//
//
//        }
//        int[][] conv4 = new int[2][2];
//        int[][] conv5 = new int[3][3];
//        for (int i = 0; i < 3; i++) {
//            if (i < 2) Arrays.fill(conv4[i], 1);
//            Arrays.fill(conv5[i], 1);
//        }
//        if (n >= 3 && m >= 3) {
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if ((i == 0 && j == 0) || (i == 0 && j == n - 1) || (i == m - 1 && j == 0) || (i == m - 1 && j == n - 1)) {
//                        int[] x =
//                    }
//                }
//
//            }
//
//        }
//    }
//}
