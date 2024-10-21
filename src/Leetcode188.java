package src;

public class Leetcode188 {
    public static void main(String[] args) {

    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k < 1) return 0;

        if (k > n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}
