package src;


public class Leetcode14 {
    public static void main(String[] args) {
        String[] s1 = {"flower","flow","flight"};
        String ans = longestCommonPrefix(s1);
        System.out.println(ans);
    }

    public static String longestCommonPrefix(String[] strs) {
        String s = "";
        for (int i = 0; i < strs.length; i++) {
            String c = strs[i].substring(0,i);
            for (int j = 0; j < strs.length; j++) {
                if(c.charAt(i) != strs[j].charAt(i)){
                    return s;
                }else{
                    s = strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}
