package src;

public class Leetcode5 {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // Base cases
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }


    // Brute Force Method
//    public String longestPalindrome(String s) {
//        int n = s.length();
//
//        for (int i=n; i>1; i--){
//            for (int j=i; j<=n; j++){
//                String sub = s.substring(j-i, j);
//                boolean res = palindrome(sub);
//                if(res)
//                    return sub;
//            }
//        }
//        return "" + s.charAt(0);
//    }
//
//    public boolean palindrome(String s){
//        char[] str = s.toCharArray();
//        int n = str.length;
//
//        for (int i=0; i < n/2; i++){
//            if (str[i] != str[n-1-i])
//                return false;
//        }
//        return true;
//    }
}
