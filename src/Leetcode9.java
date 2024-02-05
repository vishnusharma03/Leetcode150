package src;

public class Leetcode9 {
    public static void main(String[] args) {
        int x = 454;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {

        int i = 0;
        int temp = x;
        while (x > 0){
            int rem = x % 10;
            i = i * 10 + rem;
            x = x / 10;
        }
        if (i == temp) return true;
        return false;
    }
}
