package src;

import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if(s ==null||s.length()==0||t ==null||t.length()==0)
                return"";

        Map<Character, Integer> tCount = new HashMap<>();
            for(
        char c :t.toCharArray())

        {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int requiredChars = tCount.size();
        int formedChars = 0;
        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> windowCount = new HashMap<>();

            for(
        int right = 0; right<s.length();right++)

        {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formedChars++;
            }

            while (formedChars == requiredChars && left <= right) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
                    formedChars--;
                }

                left++;
            }
        }
            return minLength ==Integer.MAX_VALUE ?"":s.substring(minLeft,minLeft +minLength);
    }
}
//    public static String minWindow(String s, String t) {
//
//        HashMap<Character, Integer> Gmap = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//            if (!Gmap.containsKey(ch)) {
//                Gmap.put(ch, 1);
//            }else Gmap.put(ch, Gmap.get(ch)+1);
//        }
//
//        HashMap<Character, Integer> map = new HashMap<>(Gmap);
//        int GCount = Integer.MAX_VALUE;
//        int GFIndex = 0;
//        int GLIndex = 0;
//
//        outerLoop:
//        for (int i = 0; i < s.length(); i++) {
//            StringBuilder sb = new StringBuilder();
//            int firstIndex = Integer.MAX_VALUE;
//            map = new HashMap<>(Gmap);
//            int count = 0;
//
//            for (int index = i; index < s.length(); index++) {
//                char chr = s.charAt(index);
//                if (map.containsKey(chr) && map.get(chr) > 0){
//                    map.put(chr, map.get(chr)-1);
//                    sb.append(chr);
//                    firstIndex = Math.min(firstIndex, index);
//                }
//                if (!sb.isEmpty()) count++;
//                if (cyphers(map) && count < GCount){
//                    GFIndex = firstIndex;
//                    GLIndex = index+1;
//                    GCount = count;
//                    continue outerLoop;
//                }
//            }
//        }
//        return s.substring(GFIndex, GLIndex);
//    }
//
//    private static boolean cyphers(HashMap<Character, Integer> map) {
//        for (Integer value : map.values()) {
//            if (value != 0)
//                return false;
//        }
//        return true;
//    }
//}



//    public static String minWindow(String s, String t) {
//
//        HashMap<Character, Integer> Gmap = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//            if (!Gmap.containsKey(ch)) {
//                Gmap.put(ch, 1);
//            }else Gmap.put(ch, Gmap.get(ch)+1);
//        }
//
//        HashMap<Character, Integer> map = new HashMap<>(Gmap);
//        int GCount = Integer.MAX_VALUE;
//        int GFIndex = 0;
//        int GLIndex = 0;
//
//        outerLoop:
//        for (int i = 0; i < s.length(); i++) {
//            StringBuilder sb = new StringBuilder();
//            int firstIndex = Integer.MAX_VALUE;
//            map = new HashMap<>(Gmap);
//            int count = 0;
//
//            for (int index = i; index < s.length(); index++) {
//                char chr = s.charAt(index);
//                if (map.containsKey(chr) && map.get(chr) > 0){
//                    map.put(chr, map.get(chr)-1);
//                    sb.append(chr);
//                    firstIndex = Math.min(firstIndex, index);
//                }
//                if (!sb.isEmpty()) count++;
//                if (sb.length() == t.length() && count < GCount){
//                    GFIndex = firstIndex;
//                    GLIndex = index;
//                    GCount = count;
//                    continue outerLoop;
//                }
//            }
//        }
//        return s.substring(GFIndex, GLIndex+1).length() > t.length() ? s.substring(GFIndex, GLIndex+1) : "";
//    }
//}
