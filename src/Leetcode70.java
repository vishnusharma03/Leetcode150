package src;

import java.util.Arrays;

public class Leetcode70 {
    public static void main(String[] args) {

    }
    int[] memory;

    public int climbStairs(int n) {
        memory = new int[n+1];
        Arrays.fill(memory, -1);
        return climbStair(n);
    }

    public int climbStair(int n) {
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }
        if (memory[n] != -1){
            return memory[n];
        }
        memory[n] = climbStair(n-1) + climbStair(n-2);
        return memory[n];
    }
}
