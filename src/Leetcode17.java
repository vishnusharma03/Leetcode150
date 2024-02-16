package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode17 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, 0, new StringBuilder(), map, result);
        return result;
    }

    private static void helper(String digits, int index, StringBuilder current, HashMap<Character, String> map, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        for (char letter : map.get(digit).toCharArray()) {
            current.append(letter);
            helper(digits, index + 1, current, map, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

    // Failure 102
//    public static List<String> letterCombinations(String digits) {
//
//        HashMap<Character, List<String>> map = new HashMap<>();
//        char ch = 'a';
//        for (int i = 2; i < 10; i++) {
//            map.put((char) i, new ArrayList<>());
//            int n = 3;
//            if (i==7 || i==9) n = 4;
//            int j = 0;
//            while (j < n){
//                map.get((char) i).add(String.valueOf((char)(ch + j)));
//                j++;
//            }
//            ch = (char) (ch + j);
//
//        }
//        map.keySet().forEach(System.out::println);
//
//
//        List<String> x = new ArrayList<>();
//        StringBuilder sOne = new StringBuilder("abc");
//        StringBuilder sTwo = new StringBuilder("def");
//
//        List<List<String>> ans = new ArrayList<>();
//        for (int i = 0; i < digits.length(); i++) {
//            ans.add(map.get( digits.charAt(i)));
//            System.out.println(digits.charAt(i));
//        }
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.println(ans.get(i));
//        }
//        helperLetterCombination(new StringBuilder(), sOne, sTwo, 0, 0, x);
//        return x;
//    }
//
//    private static void helperLetterCombination(StringBuilder pro, StringBuilder up1, StringBuilder up2, int sOneIndex, int sTwoIndex, List<String> result) {
//        if (pro.length()==2){
//            result.add(pro.toString());
//            return;
//        }
//
//        while (pro.isEmpty() && sOneIndex<up1.length()){
//            StringBuilder one = new StringBuilder(String.valueOf(up1.charAt(sOneIndex)));
//            helperLetterCombination(one, up1, up2, ++sOneIndex, sTwoIndex, result);
//        }
//        while (sTwoIndex < up2.length() ) {
//            StringBuilder two = new StringBuilder(pro);
//            if (!pro.isEmpty()) two.append(up2.charAt(sTwoIndex));
//            helperLetterCombination(two, up1, up2, sOneIndex, ++sTwoIndex, result);
//        }
//    }
//}


    // Failure 101
//    private static void helperLetterCombination(StringBuilder pro, StringBuilder up1, StringBuilder up2, int sOneIndex, int sTwoIndex, List<String> result) {
//        if (pro.length()==2){
//            result.add(pro.toString());
//            pro.deleteCharAt(1);
//            return;
//        }
//
//        if (sOneIndex < up1.length()){
//            StringBuilder one = new StringBuilder(up1.charAt(sOneIndex));
//            helperLetterCombination(one, up2, up2, ++sOneIndex, sTwoIndex, result);
//            while (sTwoIndex < up2.length()){
//                StringBuilder two = new StringBuilder(pro);
//                two.append(up2.charAt(sTwoIndex));
//                helperLetterCombination(two, up1, up2, sOneIndex, ++sTwoIndex, result);
//            }
//        }
//    }
//}
