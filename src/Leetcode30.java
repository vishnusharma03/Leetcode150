package src;


import java.util.*;

public class Leetcode30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> ans = findSubstring(s, words);
        System.out.println(ans);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
            if(s ==null||words ==null||words.length ==0)return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;


        Map<String, Integer> wordMap = new HashMap<>();
        for(String word :words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i<wordLen;i++) {
        int left = i, count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int j = i; j <= s.length() - wordLen; j += wordLen) {
            String word = s.substring(j, j + wordLen);
            if (wordMap.containsKey(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                count++;

                while (map.get(word) > wordMap.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    map.put(leftWord, map.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);
                    String leftWord = s.substring(left, left + wordLen);
                    map.put(leftWord, map.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
            } else {
                map.clear();
                count = 0;
                left = j + wordLen;
            }
            }
        }
            return result;
    }
}


//    public static List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> list = new ArrayList<>();
//        HashMap<Integer, String> map = new HashMap<>();
//
//        for (int i = 0; i < words.length; i++) {
//            map.put(i, words[i]);
//        }
//        HashMap<Integer, String> tempMap = new HashMap<>(map);
//
//        int len = words[0].length();
//
//        ArrayList<Integer> temp = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i+=len) {
//            String sOne = s.substring(i, i+len);
//            if (tempMap.containsValue(sOne)){
//                tempMap.remove(sOne);
//                temp.add(i);
//            } else if (map.containsValue(sOne)) {
////                i -= len;
//                temp.clear();
//                temp.add(i);
//            } else {
//                temp.clear();
//                tempMap = new HashMap<>(map);
//
//            }
//
//            if (temp.size() == words.length){
//                list.add(temp.getFirst());
//                temp.removeFirst();
//                tempMap.put(500, sOne);
//            }
//        }
//        return list;
//    }
//}

    // Can't solve it using Permuatations method.
//    public static List<Integer> findSubstring(String s, String[] words) {
//        HashSet<String> map = new HashSet<>();
//        List<String> pro = new ArrayList<>();
//        List<String> unpro = new ArrayList<>(List.of(words));
//        helperPermutation(pro, unpro, map);
//        List<Integer> result = new ArrayList<>();
//        System.out.println(map);
//        int len = words[0].length()*words.length;
//        for (int i = 0; i < s.length(); i++) {
//
//            if (i+len <= s.length() && map.contains(s.substring(i, i+len))){
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    private static void helperPermutation(List<String> pro, List<String> unpro, HashSet<String> result) {
//        if (unpro.isEmpty()){
//            result.add(String.join("", pro));
//            return;
//        }
//        for (int i = 0; i < unpro.size(); i++) {
//            pro.add(unpro.remove(i));
//            helperPermutation(pro, unpro, result);
//            unpro.add(i, pro.removeLast());
//        }
//    }
//}

    // Can use Aho-Corasick algorithm for efficient pattern matching, but it uses trie that I haven't studied yet.
