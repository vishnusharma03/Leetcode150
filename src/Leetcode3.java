package src;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Leetcode3 {
    public static void main(String[] args) {
        String s = "abcabcbb"; //"pwwkew"; //"dvdf"; //""bbbbb";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);

    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            if (map.containsKey(rightChar)) {
                start = Math.max(start, map.get(rightChar) + 1);
            }

            map.put(rightChar, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}

    // Error 102
//    private static int lengthOfLongestSubstring(String s) {
//        ConcurrentHashMap<Integer, Character> map = new ConcurrentHashMap<>();
//        int maxLength = 0;
//        int length = 0;
//        int i = 0;
//        while (i < s.length()){
//            char c = s.charAt(i);
//            if (!map.containsValue(c)){
//                map.put(i, c);
//                length++;
//            }
//            if(i+1 < s.length())
//                i++;
//            else break;
//            char x = s.charAt(i);
//            while (map.containsValue(x) && i < s.length()){
//                for (Map.Entry<Integer, Character> entry : map.entrySet()) {
//                    if (entry.getValue().equals(x)) {
//                        map.remove(entry.getKey());
//                    }
//                }
//                map.put(i, x);
//                i++;
//                x = s.charAt(i);
//            }
//        }
//        return length;
//    }
//}

    // Error 101
//    public static int lengthOfLongestSubstring(String s) {
//        HashMap<Integer, Character> map = new HashMap<>();
//        int maxLength = 0;
//        int length = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (!map.containsValue(c)){
//                length++;
//            }else {
//                map.clear();
//                length = 1;
//            }
//            map.put(i, c);
//            maxLength = Math.max(maxLength, length);
//        }
//
//        return maxLength;
//    }
//}
