package src;

import java.util.HashMap;

public class Leetcode202 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sOne = square(n);
        while (sOne != 1) {
            boolean sTwo = map.containsKey(sOne);
            if (sTwo){
                return false;
            }else {
                map.put(sOne, 0);
                sOne = square(sOne);
            }
        }
        return true;
    }
    public static int square(int n){
        int s = 0;
        while (n > 0) {
            int rem = n % 10;
            s += rem * rem;
            n = n/10;
        }
        return s;
    }
}
