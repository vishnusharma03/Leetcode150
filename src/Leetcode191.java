package src;

public class Leetcode191 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&1)==1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
