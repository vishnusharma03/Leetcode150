package src;

public class Leetcode201 {
    public static void main(String[] args) {
        int left = 2147483646;
        int right =2147483647;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int cyphers = 0;
        while (left != right){
            left >>= 1;
            right >>= 1;
            cyphers++;
        }
        left <<= cyphers;
        return left;
    }

}

    // Time Limit Exceeded.
//    public static int rangeBitwiseAnd(int left, int right) {
//        if (left == Integer.MAX_VALUE)
//            return left;
//        int ans = left;
//        for (int i = left+1; i <= right; i++) {
//
//            ans &= i;
//            if (ans==0)
//                return 0;
//            if (i == Integer.MAX_VALUE)
//                return ans;
//        }
//        return ans;
//    }
//}
