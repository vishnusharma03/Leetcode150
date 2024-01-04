package src;

import java.util.Arrays;

public class Leetcode151 {
    public static void main(String[] args) {
        String pass = "a good   example";
        String ans  = reverseWords(pass);
        System.out.println(ans);
    }

    public static String reverseWords(String s) {
        String[] a = s.split(" ");
        StringBuilder ans = new StringBuilder();
        int x = 0;
        int y = a.length-1;
        while(x < y){
            swap(a, x, y);
            x++;
            y--;
        }
        System.out.println(Arrays.toString(a));
        for (String string : a) {
            if ((!string.equals(" ") && !string.isEmpty())) {
                ans.append(string).append(" ");
            }
        }
        System.out.println(ans);
        return ans.toString().trim();
    }

    private static void swap(String[] a, int x, int y) {
        String temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
