package src;

public class Leetcode97 {
    boolean[][][] dp;

    public static void main(String[] args) {
        Leetcode97 one = new Leetcode97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        one.dp = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        System.out.println(one.isInterleave(s1, s2,s3));

    }

    public boolean isInterleave(String s1, String s2, String s3){
        int s11 = s1.length();
        int s22 = s2.length();
        int s33 = s3.length();

        if (s11 + s22 != s33)
            return false;

        boolean[][] dp = new boolean[s11+1][s22+1];

        dp[0][0] = true;

        for (int i=1; i<=s11; i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        for (int j=1; j<=s22; j++){
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <=s11; i++) {
            for (int j = 1; j <=s22; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[s11][s22];
    }


    // Recursion + Memorization
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length())
//            return false;
//
//        return helper(s1, s1.length(), s2, s2.length(), s3, s3.length(), 0, 0, 0);
//    }
//
//    public boolean helper(String s1, int s11, String s2, int s22, String s3, int s33, int i, int j, int k){
//        if (i == s11 && j == s22 && k == s33)
//            return true;
//
//        if (dp[i][j][k])
//            return dp[i][j][k];
//
//        if (i<s11 && s1.charAt(i)==s3.charAt(k)){
//            dp[i][j][k] = helper(s1, s11, s2, s22, s3, s33, i+1, j, k+1);
//        }
//        if (j<s22 && s2.charAt(j)==s3.charAt(k)){
//            dp[i][j][k] = helper(s1, s11, s2, s22, s3, s33, i, j+1, k+1);
//        }
//
//        return dp[i][j][k];
//    }



    //Brute Force Method || Recursion Method
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length())
//            return false;
//
//        return helper(s1, s1.length(), s2, s2.length(), s3, s3.length(), 0, 0, 0);
//    }
//
//    public boolean helper(String s1, int s11, String s2, int s22, String s3, int s33, int i, int j, int k){
//        if (i == s11 && j == s22 && k == s33)
//            return true; // check why the second block is working despite being returned here
//
//        if (i<s11 && s1.charAt(i)==s3.charAt(k)){
//            if (helper(s1, s11, s2, s22, s3, s33, i+1, j, k+1))
//                return true;
//        }
//        if (j<s22 && s2.charAt(j)==s3.charAt(k)){
//            if (helper(s1, s11, s2, s22, s3, s33, i, j+1, k+1))
//                return true;
//        }
//
//        return false;
//    }
}
