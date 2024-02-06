package src;

import java.util.Arrays;

public class Leetcode66 {
    public static void main(String[] args) {
        int[] digits = {9}; //{9,8,7,6,5,4,3,2,1,0};
        int[] ans = plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length-1;
        if (digits[len] < 9){
            digits[len] += 1;
            return digits;
        }

        int i = len;
        while (i >= 0){
            if (digits[i] + 1 == 10){
                digits[i] = 0;
            }else {
                digits[i] += 1;
                return digits;
            }
            i--;
        }
        int[] ans = new int[digits.length+1];
        ans[0] = 1;
        System.arraycopy(digits, 0, ans, 1, digits.length);
        return ans;
    }
}
