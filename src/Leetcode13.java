package src;

import java.util.HashMap;

public class Leetcode13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }


    // Beats 60% of Java Users.
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int size = s.length() - 1;
        int count = map.get(s.charAt(size));
        for (int i = size; i > 0; i--) {
            int tOne = map.get(s.charAt(i-1));
            if (map.get(s.charAt(i)) <= tOne){
                count += tOne;
            }else count -= tOne;
        }

        return count;
    }
}
