package src;

public class Leetcode918 {
    public static void main(String[] args) {

    }

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        boolean flag = false;

        for (int num : nums){
            if (num >= 0) flag = true;
            currSum += num;
            totalSum += num;

            if (maxSum < currSum){
                maxSum = currSum;
            }
            if (currSum < 0){
                currSum = 0;
            }
        }

        if (flag==false) return maxSum;
        int minSum =  minimumSum(nums);
        int wrapSum = totalSum - minSum;
        if (totalSum==wrapSum) return maxSum;
        return Math.max(maxSum, wrapSum);
    }

    public int minimumSum(int[] nums){
        int n  = nums.length;
        int[] inverted = new int[n];
        for (int i=0; i < n; i++){
            inverted[i] = -1*nums[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : inverted){
            currSum += num;

            if (maxSum < currSum){
                maxSum = currSum;
            }
            if (currSum < 0){
                currSum = 0;
            }
        }
        return -1*maxSum;
    }
}
