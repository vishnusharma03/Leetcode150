package src;

import java.util.Arrays;

public class Leetcode135 {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1}; //{3,2,1,1,4,3,3}; // // {1,0,2}; // {1,2,2};
        int ans = candy(ratings);
        System.out.println(ans);
    }

    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        // Left to right pass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Summation
        int sum = Arrays.stream(candies).sum();
        return sum;
    }
}



//    public static int candy(int[] ratings) {
//        int[] candies = new int[ratings.length];
//        Arrays.fill(candies, 1);
//
//        for (int i = 0; i < ratings.length - 1; i++) {
//            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
//                candies[i] += candies[i + 1];
//                int j = i;
//                while(ratings[j] > ratings[j+1] && j > 0){
//                    if(candies[j] <= candies[j-1]){
//                        candies[j]++;
//                    }
//                    j--;
//                }
//            } else if (ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
//                candies[i + 1] += candies[i];
//            }
//        }
//        int sum = Arrays.stream(candies).sum();
//        return sum;
//    }
//}
