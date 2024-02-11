package src;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}

// Initial Thought Process upon which the above solution is derived.

//    public static List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> result = new ArrayList<>();
//
//        int i = 0;
//        int j = 0;
//        int top = 0;
//        int bottom = matrix.length;
//        int left = 0;
//        int right = matrix[0].length;
//
//        while (top < bottom || left < right){
//            while(i < right){
//                result.add(matrix[j][i]);
//                i++;
//            }
//
//            i--;
//            top++;
//            j = top;
//
//            while(j < bottom){
//                result.add(matrix[j][i]);
//                j++;
//            }
//
//            right--;
//            j--;
//            i = right;
//
//            while(i > left){
//                result.add(matrix[j][i]);
//                i--;
//            }
//
//            bottom--;
//            i++;
//            j = bottom;
//
//            while(i < right){
//                result.add(matrix[j][i]);
//                i++;
//            }
//
//            left++;
//        }
//
//        return result;
//    }
//}
