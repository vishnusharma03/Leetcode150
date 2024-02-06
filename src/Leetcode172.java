package src;

import java.math.BigInteger;
import java.util.Arrays;

public class Leetcode172 {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(trailingZeroes(n));
    }

    private static int trailingZeroes(int n) {
        int i = 1;
        int ans = 0;
        int sOne = n / 5;
        while(sOne!=0){
            i++;
            ans += sOne;
            sOne = n / (int) Math.pow(5,i);
        }
        return ans;
    }

}
    // Error 101
//    public static int trailingZeroes(int n) {
//        BigInteger nOne = BigInteger.valueOf(n);
//        BigInteger ans = BigInteger.valueOf(1);
//        while (n > 1){
//            ans = ans.multiply(nOne);
//            n = n - 1;
//        }
//        System.out.println(ans);
//        int count = 0;
//        BigInteger rem = ans.remainder(BigInteger.valueOf(10));
//        while (rem.equals(0)){
//            ans = ans.divide(BigInteger.valueOf(10));
//            rem = ans.remainder(BigInteger.valueOf(10));
//            count++;
//        }
//        return count;
//    }
//}
