package src;

import java.util.Arrays;

public class Leetcode52 {
    public static void main(String[] args) {
        Leetcode52 sv = new Leetcode52();
        System.out.println(sv.totalNQueens(1));
    }

    // Optimized Solution, Uses boolean array optimized some steps.
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        return helperQueens(board, 0);
    }

    public int helperQueens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                count += helperQueens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int r, int c){
        int i = 0;
        int n = board.length;
        for (int row = r; row >= 0 ; row--) {
            if (board[row][c])
                return false;
            if (c-i >= 0 && board[row][c-i])
                return false;
            if (c+i < n && board[row][c+i])
                return false;
            i++;
        }
        return true;
    }
}

    // Brute Force Method
//private int helperQueens(int[][] board, int r, int c, int QueensCount) {
//        int n = board.length;
//        if (r==n && QueensCount==n)
//            return 1;
//        if (r == n)
//            return 0;
//
//        int count = 0;
//        while (c < n) {
//            if (isSafe(board, r, c)) {
//                board[r][c] = 'Q';
//                QueensCount++;
//                count += helperQueens(board, r+1, 0, QueensCount);
//                board[r][c] = 0;
//                QueensCount--;
//            }
//            c++;
//        }
//        return count;
//    }
//}
