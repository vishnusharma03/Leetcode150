package src;

public class Leetcode50 {
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
    // Not optimized to solve extreme cases.
//    public static double myPow(double x, int n) {
//        if (n==0) return 1;
//        if (n==1) return x;
//        if (n<0) return myPow(x,n+1)/x;
//        return x * myPow(x , n-1);
//
//    }
//}
