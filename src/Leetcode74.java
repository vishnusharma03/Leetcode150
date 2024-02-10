package src;
public class Leetcode74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3}}; //{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        while (r < matrix.length) {
            int x = matrix[r][matrix[0].length-1];
            if (x == target)
                return true;
            else if (x < target) {
                r++;
            } else {
                return searchInsert(matrix[r], target);
            }
        }
        return false;
    }

    private static boolean searchInsert(int[] matrix, int target) {

        int start = 0;
        int end = matrix.length-1;
        int mid = 0;
        while (start <= end) {

            mid = start + (end-start) / 2;

            int midElement = matrix[mid];

            if (midElement == target) {
                return true;
            }
            else if (midElement < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
