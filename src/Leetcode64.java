package src;

import java.util.Arrays;

public class Leetcode64 {
//    static int[][] dp;
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }





    // Brute Force Method [Correct]

//    class Solution {
//        public int minPathSum(int[][] grid) {
//            int r = 0;
//            int c = 0;
//            int sum = grid[0][0];
//            int[] minSum = new int[1];
//            minSum[0] = Integer.MAX_VALUE;
//            return helper(grid, r, c, sum, minSum);
//        }
//
//        public int helper(int[][] grid, int r, int c, int sum, int[] minSum){
//            if (r==grid.length-1 && c==grid[0].length -1){
//                if (minSum[0] > sum)
//                    minSum[0] = sum;
//                return minSum[0];
//            }
//            if (r<grid.length - 1)
//                helper(grid, r+1, c, sum+grid[r+1][c], minSum);
//            if (c< grid[0].length - 1)
//                helper(grid, r, c+1, sum+grid[r][c+1], minSum);
//
//            return minSum[0];
//        }
//    }



    // No idea it is correct or not!
//    public static int recursive(int[][] grid, int r, int c, int minSum, int sum){
//        int m = grid.length;
//        int n = grid[0].length;
//        if (r==m-1 && c==n-1){
//            if (sum < minSum)
//                return sum;
//            else return minSum;
//        }
//
//        if (r<m-1 && c<n-1){
//            minSum = Math.min(recursive(grid, r+1, c, minSum, sum+grid[r+1][c]),
//                    recursive(grid, r, c+1, minSum, sum+grid[r][c+1]));
//        }
//        if (r<m-1){
//            minSum = recursive(grid, r+1, c, minSum, sum+grid[r+1][c]);
//        }
//        if (c<n-1){
//            minSum = recursive(grid, r, c+1, minSum, sum+grid[r][c+1]);
//        }
//
//        return minSum;
//    }

}
