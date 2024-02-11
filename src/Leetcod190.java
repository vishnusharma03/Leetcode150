package src;

import java.math.BigInteger;

public class Leetcod190 {
    public static void main(String[] args) {
        int n = 1001110;
        System.out.println(reverseBits(n));
    }

    private static int reverseBits(int n) {
        int sOne = 0;

        for (int i = 0; i < 32; i++) {
            sOne <<= 1;

            sOne |= (n & 1);
            n >>>= 1;
        }
        return sOne;
    }
}
    // you need treat n as an unsigned value
//    public static int reverseBits(int n) {
//        StringBuilder sOne = new StringBuilder();
//        n = Integer.parseInt(String.valueOf(n), 2);
//        while (n != 0){
//            int s = n&1;
//            sOne.append(s);
//            n = n >> 1;
//        }
//        System.out.println();
//        int ans = Integer.parseInt(sOne.toString(), 2);
//        Integer.toBinaryString(111001011110000010100101);
//        int res = Integer.parseInt(Integer.toBinaryString(ans));
//        System.out.println(ans);
//        BigInteger ans2 = new BigInteger(sOne.toString());
//        return res;
//    }
//}