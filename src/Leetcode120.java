package src;

import java.util.List;

public class Leetcode120 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.getFirst().getFirst();
        for (int i = 1; i < triangle.size(); i++) {
            int[] temp = new int[i + 1];
            temp[0] = dp[0] + triangle.get(i).getFirst();
            temp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                temp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp = temp;
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
