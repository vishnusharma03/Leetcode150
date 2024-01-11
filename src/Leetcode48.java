package src;

import java.util.Arrays;

public class Leetcode48 {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix.length - 1;

        while (top < bottom && left < right){

            int RotationCount = bottom - top;

            while (RotationCount > 0) {

                int temp = matrix[top][left];

                for (int i = top; i < bottom; i++) {
                    matrix[i][top] = matrix[i+1][top];

                }

                for (int j = left; j < right; j++) {
                    matrix[bottom][j] = matrix[bottom][j+1];
                }

                for (int k = bottom; k > top; k--) {
                    matrix[k][bottom] = matrix[k-1][bottom];
                }

                for (int l = right; l > left + 1; l--) {
                    matrix[top][l] = matrix[top][l-1];
                }
                matrix[top][left+1] = temp;
                RotationCount--;
            }
            top++;
            left++;
            right--;
            bottom--;
        }
    }
}
