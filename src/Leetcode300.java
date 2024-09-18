package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode300 {
    public static void main(String[] args) {

    }

    // Not optimized
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    // Brute-Force Method with high time complexity
//    ArrayList<ArrayList<Integer>> one = new ArrayList<>();
//    public int lengthOfLIS(int[] nums) {
//
//        int max = 1;
//        ArrayList<Integer> subset = new ArrayList<>();
//        subset(nums, subset, nums.length-1);
//
//        for (int i=0; i < one.size(); i++){
//            if (increasing(one.get(i)) && one.get(i).size()>max){
//                max = one.get(i).size();
//            }
//            System.out.println(Arrays.toString(one.get(i).toArray()));
//        }
//        return max;
//    }
//
//    public boolean increasing(ArrayList<Integer> temp){
//        for (int i=1; i < temp.size(); i++){
//            if (temp.get(i)<= temp.get(i-1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void subset(int[] nums, ArrayList<Integer> x, int n){
//        if (n < 0){
//            one.add(new ArrayList<>(x));
//            return;
//        }
//
//        subset(nums, new ArrayList<>(x), n-1);
//        x.add(0, nums[n]);
//        subset(nums, new ArrayList<>(x), n-1);
//        // x.remove(0);
//    }

}
