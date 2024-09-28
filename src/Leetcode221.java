package src;

public class Leetcode221 {
    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i=0; i<m; i++){
            if (matrix[i][0]=='1'){
                dp[i][0] = 1;
                if(dp[i][0] > max)
                    max = dp[i][0];
            }
            else dp[i][0] = 0;
        }
        for (int j=0; j<n; j++){
            if (matrix[0][j]=='1'){
                dp[0][j] = 1;
                if(dp[0][j] > max)
                    max = dp[0][j];
            }
            else dp[0][j] = 0;
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (matrix[i][j]=='0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    if (dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}
