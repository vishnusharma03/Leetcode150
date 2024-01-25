package src;

import java.util.HashMap;

public class Leetcode383 {
    public static void main(String[] args) {
        String ransomNote = "ac";
        String magazine = "abc";
        boolean result = canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (count[index] <= 0) {
                return false;
            }
            count[index]--;
        }

        return true;
    }

}

// Brute Force Method
//    public static boolean canConstruct(String ransomNote, String magazine) {
//        HashMap<Character, Integer> mag = new HashMap<>();
//        for (int i = 0; i < magazine.length(); i++) {
//            char c = magazine.charAt(i);
//            mag.put(c, mag.getOrDefault(c,0) + 1);
//        }
//
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char check = ransomNote.charAt(i);
//            Integer count = mag.get(check);
//            if (count!=null && count > 0){
//                mag.put(check,count);
//            }else return false;
//        }
//        return true;
//    }
//
//}
