package src;

public class Leetcode14 {
    public static void main(String[] args) {
        String[] s1 = {"ab", "a"}; // {"flower","flow","flight"};
        String ans = longestCommonPrefix(s1);
        System.out.println(ans);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) return "";
        int index = 0;

        while(true){
            for (int i = 0; i < strs.length; i++) {
                if (index>=strs[i].length() || strs[i].charAt(index)!=strs[0].charAt(index)){
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
    }
}
