package src;

import java.util.HashSet;

public class Leetcode36 {
    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                         {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                         {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                         {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                         {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                         {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                         {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                         {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                         {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};


        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> map = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (map.contains(board[r][c])) return false;
                if (board[r][c] != '.')
                    map.add(board[r][c]);
            }
            map.clear();
        }

        for (int c = 0; c < board.length; c++) {
            for (int r = 0; r < board[0].length; r++) {
                if (map.contains(board[r][c])) return false;
                if (board[r][c] != '.')
                    map.add(board[r][c]);
            }
            map.clear();
        }
        int BB = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6){
                BB++;
            }
            if (!helperValidation(BB, i, board)) return false;
        }


        return true;
    }

    private static boolean helperValidation(int bb, int block, char[][] board) {
        HashSet<Character> map = new HashSet<>();

        for (int row = bb*3; row < bb*3+3; row++) {
            for (int col = (block % 3) * 3; col < ((block % 3) * 3 )+ 3; col++) {
                if (map.contains(board[row][col])) return false;
                if (board[row][col] != '.')
                    map.add(board[row][col]);
            }
        }
        return true;
    }
}

    // Optimization
//    public static boolean isValidSudoku(char[][] board) {
//
//        boolean[][] row = new boolean[9][9];
//
//        boolean[][] col = new boolean[9][9];
//
//        boolean[][] sub = new boolean[9][9];
//
//        for (int i = 0; i < 9; ++i) {
//
//            for (int j = 0; j < 9; ++j) {
//
//                char c = board[i][j];
//
//                if (c == '.') {
//
//                    continue;
//
//                }
//
//                int num = c - '0' - 1;
//
//                int k = i / 3 * 3 + j / 3;
//
//                if (row[i][num] || col[j][num] || sub[k][num]) {
//
//                    return false;
//
//                }
//
//                row[i][num] = true;
//
//                col[j][num] = true;
//
//                sub[k][num] = true;
//
//            }
//
//        }
//
//        return true;
//
//    }



