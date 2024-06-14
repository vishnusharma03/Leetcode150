package src;

import java.util.*;
import java.util.LinkedList;

public class Leetcode433 {
    public static void main(String[] args) {

    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, List<String>> adj = new HashMap<>();

        adj.put(startGene, new ArrayList<>());
        for (String s : bank){
            if (mutationCheck(startGene, s)){
                adj.get(startGene).add(s);
            }
        }

        for (String s1 : bank){
            adj.putIfAbsent(s1, new ArrayList());
            for (String s2 : bank){
                if (mutationCheck(s1, s2)){
                    adj.get(s1).add(s2);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        int moves = 0;
        visited.add(startGene);

        while(!queue.isEmpty())  {
            int size = queue.size();
            for (int i=0; i<size; i++){
                String curr = queue.poll();
                if (curr.equals(endGene)) return moves;

                for (String s : adj.get(curr)){
                    if (!visited.contains(s)){
                        visited.add(s);
                        queue.add(s);
                    }
                }
            }
            moves++;
        }
        return -1;
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
