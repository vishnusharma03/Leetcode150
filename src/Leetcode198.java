package src;

import java.util.Arrays;

public class Leetcode198 {
    public static void main(String[] args) {
        Leetcode198 one = new Leetcode198();
        int[] nums = {2,7,9,3,1};
        int ans = one.rob(nums);
        System.out.println(ans);
    }

    int[] memory;
    public int rob(int[] nums) {
        int n = nums.length;
        memory = new int[n+1];
        Arrays.fill(memory, -1);
        return robb(nums, 0, n-1);
    }
    public int robb(int[] nums, int profit, int n){
        if (n==0){
            return nums[0];
        }
        if ( n==1){
            return Math.max(nums[0], nums[1]);
        }
        if (memory[n]!= -1){
            return memory[n];
        }
        memory[n] = Math.max(profit+nums[n]+ robb(nums, profit, n-2), robb(nums, profit, n-1));
        return memory[n];
    }
}
