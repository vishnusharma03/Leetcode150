package src;

import jdk.dynalink.linker.LinkerServices;

public class Leetcode72 {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        // dp[m][n] = 0;

        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else {
                    int small = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = 1 + Math.min(small, dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}

// What did I learn??
// Conversion of the conditions insert, delete & replace to dynamic programming.
// aka bottom up dp

//    public static int helper(String w1, String w2, int i, int j){
//        if (w1.isEmpty() && w2.isEmpty())
//            return 0;
//        if (w1.isEmpty())
//            return w2.length();
//        if (w2.isEmpty())
//            return w1.length();
//
//        if (w1.charAt(i)==w2.charAt(j))
//            return helper(w1,w2, i+1, j+1);
//        else {
//            int small = Math.min(insert(w1,w2, i, j), delete(w1,w2, i, j));
//            return Math.min(small, replace(w1,w2,i,j));
//        }
//    }
//
//    private static int replace(String w1, String w2, int i, int j) {
//        w1.charAt(i-1) =
//    }
//
//    private static int delete(String w1, String w2, int i, int j) {
//
//
//    }
//
//    private static int insert(String w1, String w2, int i, int j) {
//        return 0;
//    }
//}
