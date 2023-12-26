public class Leetcode122 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int x = maxProfit(arr);
        System.out.println(x);
    }
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]){
                sum += prices[i+1] - prices[i];
            }
        }
        return sum;
    }
}
