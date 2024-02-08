package src;

import java.math.BigInteger;

public class Leetcode67 {
    public static void main(String[] args) {
        String a = "11"; //""10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "1"; //""110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                System.out.println(sum);
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            ans.append(sum % 2);
            carry = sum / 2;
        }

        return ans.reverse().toString();
    }
}

//    private static String addBinary(String a, String b) {
//
//        BigInteger aOne = new BigInteger(a,2);
//        BigInteger bOne = new BigInteger(b,2);
//
//        while (!bOne.equals(new BigInteger(String.valueOf(0)))){
//            BigInteger carry = aOne.and(bOne);
//            aOne = aOne.xor(bOne);
//            bOne = carry.shiftLeft(1);
//        }
//        String ans = aOne.toString(2);
//        return ans;
//    }
//
//}


//    // Brute Force Method || Bit Manipulation isn't used here.
//    private static String addBinary(String a, String b) {
//        BigInteger sOne = new BigInteger(a,2);
//        BigInteger sTwo = new BigInteger(b,2);
//        BigInteger ans = sOne.add(sTwo);
//        return ans.toString(2);
//    }
//}

    // senseless execution || DO NOT READ FURTHER
    // We this method could have achieved best results if implemented correctly.

//    public static String addBinary(String a, String b) {
//        int last = 0;
//        StringBuilder fukc = new StringBuilder();
//        for (int i = Math.min(a.length(), b.length()) - 1; i >= 0; i++) {
//            char cOne = a.charAt(i);
//            char cTwo = b.charAt(i);
//            if (cOne==0 && cTwo==0) {
//
//            }
//            else if ((cOne == 0 && cTwo==1) || (cOne==1 && cTwo==0)) {
//
//            }
//            else {
//                last = 1;
//                return 0;
//            }
//            fukc.append(addb(, b.charAt(i)));
//        }
//        int ans = sOne + sTwo;
//        String binaryAns = Integer.toBinaryString(ans);
//        return binaryAns;
//    }
//
//    private static int addb(char cOne, char cTwo) {
//
//    }
//}
