package src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode30 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        //System.out.println(s.indexOf(""));
        List<Integer> ans = findSubstring(s, words);
        System.out.println(ans);
    }

    // Can use Aho-Corasick algorithm for efficient pattern matching, but it uses trie that I haven't studied yet.
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int length = words.length + words[0].length();
        if (s.length() < length)
            return new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(i, words[i]);
        }
        int start = 0;
        for (int end = 0; end < s.length() - length; end++) {
//            list = ahoCorasickMatch(text, patterns);
        }
        return new ArrayList<>();
    }
}
