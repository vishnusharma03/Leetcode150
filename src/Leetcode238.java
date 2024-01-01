package src;

import java.util.Arrays;

public class Leetcode238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ret = productExceptSelf(nums);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        int left = 1;
        for(int i=0; i< nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i=nums.length-1; i>=0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}



//    public static int[] productExceptSelf(int[] nums) {
//
//        int[] ans = new int[nums.length];
//
//        int[] left = new int[]{1, 1, 1, 1};
//        int x =1;
//        for(int i=0; i< nums.length; i++) {
//            left[i] *= nums[i] * x;
//        }
//        System.out.println(Arrays.toString(left));
//        int y= 1;
//        int[] right = new int[]{1, 1, 1, 1};
//        for(int i=nums.length-1; i>=0; i--) {
//            right[i] *= nums[i] * y;
//        }
//        System.out.println(Arrays.toString(right));
//
//        for (int i =1; i < nums.length-1; i++) {
//            ans[i] = left[i-1] * right[i+1];
//        }
//        ans[0] = right[0];
//        ans[nums.length-1] = left[0];
//        return ans;
//    }
//}


//   ## Brute Force Method
//    public static int[] productExceptSelf(int[] nums) {
//        int[] ans = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i){
//                    sum *= nums[j];
//                }
//            }
//            ans[i] = sum;
//        }
//        return ans;
//    }
//}
