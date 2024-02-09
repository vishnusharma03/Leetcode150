package src;

import java.util.Arrays;

public class Leetcode137 {
    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}


// Inefficient Method || Yields error for long numbers.
//    public static int singleNumber(int[] nums) {
//        long[] numsBinary = new long[nums.length];
//        long ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            numsBinary[i] = Integer.parseInt(Integer.toBinaryString(nums[i]));
//            ans += numsBinary[i];
//        }
//
//        String sOne = String.valueOf(ans);
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < sOne.length(); i++) {
//            int a = Integer.parseInt(String.valueOf(sOne.charAt(i))) % 3;
//            res.append(a);
//        }
//        int fres = Integer.parseInt(res.toString(), 2);
//
//        return fres;
//    }
//}
