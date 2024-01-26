package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class Leetcode242 {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }


    // Beats 84% of Java Users
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sOne = s.toCharArray();
        char[] tOne = t.toCharArray();
        Arrays.sort(sOne);
        Arrays.sort(tOne);
        for (int i = 0; i < sOne.length; i++) {
            if (sOne[i] != tOne[i])
                return false;
        }
        return true;
    }
}


// This question cannot achieve much efficiency if hashmap is usd but this question is specifically of topic
// hashmap in Leetcode150

// Brute Force Method || Beats 23% of Java Users
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character k = s.charAt(i);
//            map.put(k, map.getOrDefault(k,0)+1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            Character c = t.charAt(i);
//            Integer count = map.get(c);
//            if (count==null || count <=0){
//                return false;
//            } else {
//                map.put(c, map.get(c)-1);
//            }
//        }
//        return true;
//    }
//}
