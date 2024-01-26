package src;

import java.util.HashMap;
import java.util.Objects;

public class Leetcode290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] sOne = s.split(" ");
        int length = sOne.length;
        if (pattern.length() != length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character c = pattern.charAt(i);
            String sTwo = sOne[i];
            boolean val = !map.containsValue(sTwo);
            if (!map.containsKey(c) && val){
                map.put(c, sTwo);
            } else if (val || !Objects.equals(map.get(c), sTwo)) {
                return false;
            }
        }
        return true;
    }
}
