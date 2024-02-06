package src;

public class Leetcode69 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(mySqrt(x));
    }

    // Binary Search Method
    private static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

}

    // Failed Newton-Raphson Method
//        public static int mySqrt(int x) {
//            if(x==0)
//                return 0;
//            else if (x==1)
//                return 1;
//            int s = Math.max(x/2, 1);
//            double sOne = s*s - x;
//            double sTwo = 0.5*(sOne + x/sOne);
//            while (Math.abs(sTwo - sOne) > 0.1){
//
//                sOne = sTwo*sTwo - x;
//                sTwo = 0.5*(sOne + x/sOne);
//            }
//            return (int) sOne;
//        }'
//}
