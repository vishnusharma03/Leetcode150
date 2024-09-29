package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Leetcode123 {
    public static void main(String[] args) {
        Leetcode123 one = new Leetcode123();
        int[] maxi = {3,3,5,0,0,3,1,4}; // {3,3,5,0,0,3,1,4};

        System.out.println(one.maxProfit(maxi));

     }

     // Optimized approach: Divided the problem in 2 parts to calculate the max profit using
     // 1 transaction in either direction & combined the result to find the answer.
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;

        int[] profitLeft = new int[n];

        int[] profitRight = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]);
        }

        return maxProfit;
    }

     // Brute Force approach where the idea is first calculate the individual difference between the
     // prices & then add the continuous positives that will be treated as one entity & find the
     // max 2 values in this array or thing & add them to get the answer.
    // Issues: Few cases are being missed.

//    public int maxProfit(int[] prices) {
//        int m = prices.length;
//        if (m==1){
//            return 0;
//        }
//
//        int[] dp = new int[m];
//
//        for (int i=1; i<m;i++){
//            dp[i] = prices[i] - prices[i-1];
//        }
//        System.out.println(Arrays.toString(dp));
//
//        ArrayList<Integer> sums = new ArrayList<>();
//        int sum = 0;
//
//        for (int num : dp) {
//            if (num >= 0) {
//                sum += num;
//            } else {
//
//                if (sum > 0) {
//                    sums.add(sum);
//                }
//                sum = 0;
//            }
//        }
//
//        if (sum > 0) {
//            sums.add(sum);
//        }
//
//        if (sums.size() < 2) {
//            return sums.isEmpty() ? 0 : Collections.max(sums);
//        }
//
//        Collections.sort(sums, Collections.reverseOrder());
//        System.out.println(sums.toString());
//        return sums.get(0)+sums.get(1);
//    }
}
