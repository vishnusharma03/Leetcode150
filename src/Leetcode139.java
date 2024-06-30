package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode139 {
    public static void main(String[] args) {
        Leetcode139 one = new Leetcode139();
        String s = "leetcode"; // "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(one.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i<=n; i++){
            for (int j = 0; j<=i; j++){
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
    // Error 101
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//        String two = "";
//        int j = 0;
//        StringBuilder res = new StringBuilder();
//        for (int i=0; i<=s.length(); i++){
//            two = s.substring(j,i);
//            if (set.contains(s.substring(j,i))){
//                res.append(s, j, i);
//                j = i;
//            }
//            if (res.toString().equals(s)) return true;
//        }
//        return false;
//    }
//}
