package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode73 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // Using boolean arrays instead of ArrayList to reduce time & space complexity
    private static void setZeroes(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


// Brute Force Method
//    public static void setZeroes(int[][] matrix) {
//        List<Integer> rows = new ArrayList<>();
//        List<Integer> cols = new ArrayList<>();
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 0){
//                    if (!rows.contains(i)) {
//                        rows.add(i);
//                    }
//                    if (!cols.contains(j)) {
//                        cols.add(j);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//               if (rows.contains(i) || cols.contains(j)){
//                   matrix[i][j] = 0;
//               }
//            }
//        }
//
//    }
//}
