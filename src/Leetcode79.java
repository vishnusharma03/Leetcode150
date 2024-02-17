package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode79 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        String word = "aaaaaaaaaaja";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (board[i][j] == '#') {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = helper(board, word, i, j + 1, index + 1) ||
                helper(board, word, i + 1, j, index + 1) ||
                helper(board, word, i, j - 1, index + 1) ||
                helper(board, word, i - 1, j, index + 1);
        board[i][j] = temp;
        return found;

    }
}

    // Very efficient in terms of memory than solution below as unnecessary recursion calls were removed.
//    public static boolean exist(char[][] board, String word) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    boolean check = helperExist(board, new StringBuilder(), i, j, word, 0);
//                    if (check) return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean helperExist(char[][] board, StringBuilder path, int rows, int cols, String word, int wI) {
//
//        if (wI == word.length() - 1) {
//            return true;
//        }
//
//        if (board[rows][cols] != '0') {
//            path.append(board[rows][cols]);
//            board[rows][cols] = '0';
//
//            if (rows < board.length - 1 && board[rows + 1][cols] == word.charAt(wI + 1) && helperExist(board, path, rows + 1, cols, word, wI + 1)) {
//                return true;
//            }
//            if (cols < board[0].length - 1 && board[rows][cols + 1] == word.charAt(wI + 1) && helperExist(board, path, rows, cols + 1, word, wI + 1)) {
//                return true;
//            }
//            if (rows > 0 && board[rows - 1][cols] == word.charAt(wI + 1) && helperExist(board, path, rows - 1, cols, word, wI + 1)) {
//                return true;
//            }
//            if (cols > 0 && board[rows][cols - 1] == word.charAt(wI + 1) && helperExist(board, path, rows, cols - 1, word, wI + 1)) {
//                return true;
//            }
//
//            board[rows][cols] = path.charAt(path.length() - 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//        return false;
//    }
//}


    // Brute Force Method
//    public static boolean exist(char[][] board, String word) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    StringBuilder flag = new StringBuilder();
//                    boolean check = helperExist(board, new StringBuilder(), i, j, word, 0, flag);
//                    if (!flag.isEmpty()) return true;
//                }
//            }
//        }
//        return false;
//    }

//    private static boolean helperExist(char[][] board, StringBuilder path, int rows, int cols, String word, int wI, StringBuilder flag) {
//
//        if (wI == word.length()-1) {
//            flag.append("1");
//            return true;
//        }
//
//        if (board[rows][cols] != '0') {
//            path.append(board[rows][cols]);
//            board[rows][cols] = '0';
//
//            if (rows < board.length-1 && board[rows+1][cols]==word.charAt(wI+1)){
//                helperExist(board, path,rows+1, cols, word, wI+1, flag);
//            }
//            if (cols < board[0].length-1 && board[rows][cols+1]==word.charAt(wI+1)){
//                helperExist(board, path, rows, cols+1, word, wI+1, flag);
//            }
//            if (rows > 0 && board[rows-1][cols]==word.charAt(wI+1)){
//                helperExist(board, path, rows-1, cols, word, wI+1, flag);
//            }
//            if (cols > 0 && board[rows][cols-1]==word.charAt(wI+1)){
//                helperExist(board, path, rows, cols-1, word, wI+1, flag);
//            }
//
//            board[rows][cols] = path.charAt(path.length()-1);
//            path.deleteCharAt(path.length()-1);
//        }
//        return false;
//    }
//}

