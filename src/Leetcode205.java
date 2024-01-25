package src;

import java.util.HashMap;

public class Leetcode205 {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sOne = s.charAt(i);
            Character tOne = t.charAt(i);
            if (!map.containsKey(sOne)){
                if (map.containsValue(tOne)){
                    return false;
                }
                map.put(sOne, tOne);
            }else {
                if (map.get(sOne) != tOne)
                    return false;
            }
        }

        return true;
    }
}

// Optimized method but not my solution, just here for future reference

//    public static boolean isIsomorphic(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        int[] mapST = new int[256]; // Mapping of characters from s to t
//        int[] mapTS = new int[256]; // Mapping of characters from t to s
//        Arrays.fill(mapST, -1);
//        Arrays.fill(mapTS, -1);
//
//        for (int i = 0; i < s.length(); i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//
//            // Check if the mapping is already established and consistent
//            if (mapST[c1] != -1 || mapTS[c2] != -1) {
//                if (mapST[c1] != c2 || mapTS[c2] != c1) {
//                    return false;
//                }
//            } else {
//                // Establish the new mapping
//                mapST[c1] = c2;
//                mapTS[c2] = c1;
//            }
//        }
//
//        return true;
//    }
