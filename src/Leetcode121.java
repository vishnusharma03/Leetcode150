import java.util.ArrayList;

public class Leetcode121 {
    public static void main(String[] args) {
        int[] price = {3, 2, 6, 5, 0, 3};
        int result = maxProfit(price);
        System.out.println(result);
    }


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }

//    public static int maxProfit(int[] prices) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        int max = 0;
//        for (int i = prices.length - 1; i > 0; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                arr.add(prices[i] - prices[j]);
//            }
//        }
//        for (int i = 0; i < arr.size(); i++) {
//            if (max < arr.get(i)) {
//                max = arr.get(i);
//            }
//            if (max > 0) {
//                return max;
//            }
//        }
//        return 0;
//    }

//    public static int maxProfit(int[] prices) {
//        return profit(prices, 0, prices.length-1);
//    }
//
//    public static int profit(int[] prices, int beg, int fin){
//        int mini = getmin(prices, beg, fin);
//        if (fin == -1){return 0;}
//        if (mini != -1 && mini != fin){
//            int maxi = getmax(prices, mini+1, fin);
//            int ans = prices[maxi] - prices[mini];
//            return ans;
//        } else if (mini == fin) {
//            return profit(prices, beg, fin-1);
//        }
//        return 0;
//    }
//
//    public static int getmin(int[] arr, int i, int l){
//        int min = arr[i];
//        int minindex = i;
//        for (int j = i+1; j <= l; j++) {
//            if (min > arr[j]){
//                min = arr[j];
//                minindex = j;
//            }
//        }
//        return minindex;
//    }
//
//    public static int getmax(int[] arr, int i, int l) {
//        int max = arr[i];
//        int maxindex = i;
//        for (int j = i + 1; j <= l; j++) {
//            if (max < arr[j]) {
//                max = arr[j];
//                maxindex = j;
//            }
//        }
//        return maxindex;
//    }
}
