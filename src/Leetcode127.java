package src;

import java.util.*;
import java.util.LinkedList;

public class Leetcode127 {
    public static void main(String[] args) {

    }

    // Efficient Method
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wList = new HashSet<>(wordList);
        Set<String> bSet = new HashSet<>();
        Set<String> eSet = new HashSet<>();
        if (!wList.contains(endWord)) return 0;
        bSet.add(beginWord);
        eSet.add(endWord);
        int res = 1;
        Set<String> visited = new HashSet<>();
        while (!bSet.isEmpty() && !eSet.isEmpty()) {
            if (bSet.size() > eSet.size()) {
                Set<String> set = bSet;
                bSet = eSet;
                eSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word: bSet) {
                char[] cs = word.toCharArray();

                for (int i = 0; i < cs.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char old = cs[i];
                        cs[i] = j;
                        String t = String.valueOf(cs);
                        if (eSet.contains(t)) return res+1;
                        if (!visited.contains(t) && wList.contains(t)) {
                            temp.add(t);
                            visited.add(t);
                        }
                        cs[i] = old;
                    }
                }
            }

            bSet = temp;
            res++;
        }

        return 0;
    }

    // Brute Force Method
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adj = new HashMap<>();

        adj.put(beginWord, new ArrayList<>());
        for (String s : wordList){
            if (mutationCheck(beginWord, s)){
                adj.get(beginWord).add(s);
            }
        }

        for (String s1 : wordList){
            adj.putIfAbsent(s1, new ArrayList());
            for (String s2 : wordList){
                if (mutationCheck(s1, s2)){
                    adj.get(s1).add(s2);
                }
            }
        }
        System.out.println(adj);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        int moves = 1;
        visited.add(beginWord);

        while(!queue.isEmpty())  {
            int size = queue.size();
            for (int i=0; i<size; i++){
                String curr = queue.poll();
                if (curr.equals(endWord)) return moves;

                for (String s : adj.get(curr)){
                    if (!visited.contains(s)){
                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
            moves++;
        }
        return 0;
    }

    private boolean mutationCheck(String first, String second){
        int count = 0;
        for (int i=0; i<first.length(); i++){
            if (first.charAt(i) != second.charAt(i))
                count++;
        }
        return count==1;
    }
}
