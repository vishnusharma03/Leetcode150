package src;

public class Leetcode53 {
    public static void main(String[] args) {

    }


    // Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums){
            currSum += num;

            if (maxSum < currSum){
                maxSum = currSum;
            }
            if (currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}
