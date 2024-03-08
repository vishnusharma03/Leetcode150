package src;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Leetcode71 {
    public static void main(String[] args) {
        Leetcode71 sv = new Leetcode71();
        String path = "/a//b////c/d//././/.."; //  "/a/../../b/../c//.//" ;  // "/a/./b/../../c/";
        String ans = sv.simplifyPath(path);
        System.out.println(ans);
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!token.equals(".") && !token.isEmpty()) {
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String token : stack) {
            sb.append("/").append(token);
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
    }


//    public String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//        StringBuilder build = new StringBuilder();
//
//        String[] fpath = path.split("/");
//        for (String sone : fpath){
//            stack.push(sone);
//        }
//        int count = 1;
//        while (!stack.isEmpty()){
//            String s = stack.pop();
//            while ("..".equals(s)) {
//                count++;
//                s = stack.pop();
//                if (!"..".equals(s))
//                    s = "";
//            }
//            while (count-1 > 0){
//                if (stack.isEmpty()){
//                    return build.toString().isEmpty() ? "/" : build.toString();
//                }
//                s = stack.pop();
//                if (!s.equals(".") && !s.isEmpty())
//                    count--;
//                if (count-1==1) s = "";
//            }
////            s = stack.pop();
//            // Learn why am I using Objects.equals & s.equals [Done]
//            // IntelliJ autocorrect
//            if (!Objects.equals(s, ".") && !Objects.equals(s, "")) {
//                build.insert(0, s);
//                build.insert(0, "/");
//            }
//        }
//        return build.toString().isEmpty() ? "/" : build.toString();
//    }
//}



//    public String simplifyPath(String path) {
//        Stack<String> stack = new Stack<>();
//        StringBuilder build = new StringBuilder();
//
//        String[] fpath = path.split("/");
//        for (String sone : fpath){
//            stack.push(sone);
//        }
//
//        while (!stack.isEmpty()){
//            String s = stack.pop();
//            if ("..".equals(s)) {
//                stack.pop();
//            }
//
//            // Learn why am I using Objects.equals & s.equals
//            // IntelliJ autocorrect
//            else if (!Objects.equals(s, ".") && !Objects.equals(s, "")) {
//                build.insert(0, s);
//                build.insert(0, "/");
//            }
//        }
//        return build.toString().isEmpty() ? "/" : build.toString();
//    }
//}
