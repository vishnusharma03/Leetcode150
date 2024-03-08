package src;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode20 {
    public static void main(String[] args) {
        Leetcode20 sv = new Leetcode20();
        String s = "(){}[]}";
        System.out.println(sv.isValid(s));
    }


    // Worst Time complexity then previous solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char str: s.toCharArray()) {

            if (map.containsKey(str)){
                stack.push(str);
            }
            if (map.containsValue(str)){
                if (stack.isEmpty()) return false;
                char x = stack.pop();
                if (str!=map.get(x)) return false;
            }
        }

        return stack.isEmpty();
    }
}


    // Beats 50% Users
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        int i = 0;
//        while (i < s.length()) {
//            char sone = s.charAt(i);
//            if (sone == '(' || sone == '{' || sone == '[') {
//                stack.push(sone);
//            }
//            if (sone == ')' || sone == '}' || sone == ']') {
//                if (stack.isEmpty()) return false;
//                char x = stack.pop();
//                if (sone != corrs(x)) return false;
//            }
//            i++;
//        }
//
//        return stack.isEmpty();
//    }
//
//    private char corrs(char x) {
//    if (x=='(') return ')';
//    if (x=='{') return '}';
//    if (x=='[') return ']';
//    return ' ';
//    }
//}
