package src;

import java.util.Arrays;

public class Leetcode322 {
    public static void main(String[] args) {
        Leetcode322 one = new Leetcode322();
        int amount = 13;
        int[] coins = {2,5};

        int ans = one.coinChange(coins, amount);
        System.out.println(ans);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
