package src;

public class Leetcode28 {
    public static void main(String[] args) {
        String haystack = "sabutsad";
        String needle = "sad";
        int ans = strStr(haystack, needle);
        System.out.println(ans);
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;
        while(i < haystack.length() - needle.length() +1){
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
