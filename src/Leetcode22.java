package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helperGenerateParenthesis(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void helperGenerateParenthesis(List<String> result, StringBuilder current, int openCount, int closeCount, int n) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (openCount < n) {
            current.append("(");
            helperGenerateParenthesis(result, current, openCount + 1, closeCount, n);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeCount < openCount) {
            current.append(")");
            helperGenerateParenthesis(result, current, openCount, closeCount + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}


    // Error 101
//    public static List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        StringBuilder bOpen = new StringBuilder();
//        StringBuilder bClosed = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            bOpen.append("(");
//            bClosed.append(")");
//        }
//        helperGenerateParenthesis(result, new StringBuilder(), bOpen, bClosed, 0, 0);
//        return result;
//    }
//
//    private static void helperGenerateParenthesis(List<String> result, StringBuilder processed, StringBuilder bOpen, StringBuilder bClosed, int ac, int bc) {
//        if (bOpen.isEmpty() && bClosed.isEmpty()){
//            result.add(processed.toString());
//            System.out.println(result);
//            return;
//        }
//
//        if (!bOpen.isEmpty()) {
//            StringBuilder x = new StringBuilder();
//            x.append(processed);
//            x.append(bOpen.charAt(0));
//            StringBuilder y = new StringBuilder();
//            y.append(bClosed);
//            y.deleteCharAt(0);
//            helperGenerateParenthesis(result, x, y,
//                    bClosed, ++ac, bc);
//        }
//        if (ac > bc && !bClosed.isEmpty()) {
//            StringBuilder z = new StringBuilder();
//            z.append(processed);
//            z.append(bClosed.charAt(0));
//            StringBuilder m = new StringBuilder();
//            m.append(bOpen);
//            m.deleteCharAt(0);
//            helperGenerateParenthesis(result, z, bOpen, m,
//                    ac, ++bc);
//        }
//    }
//}
