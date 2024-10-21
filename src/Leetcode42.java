package src;

import java.util.Arrays;

public class Leetcode42 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1}; //{4,2,0,3,2,5};
        int ans = trap(nums);
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        int left = 0, right = len - 1;
        int left_max = 0, right_max = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    sum += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    sum += right_max - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}


// Brute Force Method

//    public int trap(int[] height) {
//        int len = height.length;
//        int sum = 0;
//        int[] left_max = new int[len];
//        int[] right_max = new int[len];
//
//        left_max[0] = height[0];
//        for (int i=1; i<len; i++){
//            left_max[i] = Math.max(height[i], left_max[i-1]);
//        }
//        System.out.println(Arrays.toString(left_max));
//
//        right_max[len-1] = height[len-1];
//        for (int i=len-2; i>=0; i--){
//            right_max[i] = Math.max(height[i], right_max[i+1]);
//        }
//        System.out.println(Arrays.toString(right_max));
//
//        for (int i=1; i<len; i++){
//            int x = Math.min(left_max[i], right_max[i]) - height[i];
//            System.out.println(x);
//            if (x>0)
//                sum += x;
//        }
//        return sum;
//    }
