package src;

import java.util.*;

public class Leetcode207 {
    public static void main(String[] args) {

    }

    // Brute Force
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = buildGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : map.keySet()) {
            if (!visited.contains(node)) {
                if (checkCycles(map, visited, recStack, node)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkCycles(Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> recStack, int node) {
        if (recStack.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
            if (checkCycles(map, visited, recStack, neighbor)) {
                return true;
            }
        }

        recStack.remove(node);
        return false;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] pre){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<pre.length; i++){
            int src = pre[i][0];
            int des = pre[i][1];

            map.putIfAbsent(src, new ArrayList<>());
            map.get(src).add(des);

            map.putIfAbsent(des, new ArrayList<>()); // To ensure all vertex are present in the map.
        }
        return map;
    }
}
