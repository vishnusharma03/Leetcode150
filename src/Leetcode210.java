package src;

import java.util.*;

public class Leetcode210 {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = numCourses;
        for(int i =0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int prerequisite[]: prerequisites)
        {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean visited[] = new boolean[n];
        boolean completed[] = new boolean[n];
        boolean ans = true;
        ArrayList<Integer> completedCourses = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                ans = ans && dfs(i, adj, visited, completed,  completedCourses);
                if(ans)
                {   completedCourses.add(i);
                    completed[i] = true;
                }
            }
        }
        int c = 0;
        int[] answer = new int[n];
        for(int i: completedCourses)
            answer[c++] = i;


        if(!ans) return new int[0];

        return answer;

    }

    boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean completed[], ArrayList<Integer> order)
    {
        boolean ans = true;
        for(int nbr: adj.get(start))
        {
            if(completed[nbr])
                continue;

            if(visited[nbr])
                return false;

            visited[nbr] = true;
            ans = ans && dfs(nbr,adj,visited, completed, order);

            if(ans)
            {
                completed[nbr] = true;
                order.add(nbr);
            }
        }
        return ans;
    }

    // Brute Force
    // Build Recursion tree for better understanding the working

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> map = buildGraph(prerequisites);
//        Set<Integer> visited = new HashSet<>();
//        Set<Integer> recStack = new HashSet<>();
//        List<Integer> order = new ArrayList<>();
//        boolean hasCycle = false;
//        int[] result = new int[numCourses];
//
//        for (int i=0; i < numCourses; i++){
//            if (!visited.contains(i)){
//                if (checkCycles(map, visited, recStack, i)){
//                    hasCycle = true;
//                    break;
//                }
//            }
//        }
//        if (hasCycle){
//            return new int[0];
//        }
//
//        visited.clear();
//        for (int i=0; i<numCourses; i++){
//            if (!visited.contains(i)){
//                Order(map, visited, order, i);
//            }
//        }
//        Collections.reverse(order);
//        for (int i=0; i<numCourses; i++){
//            result[i] = order.get(i);
//        }
//
//        return result;
//    }
//
//    private void Order(Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> order, int node) {
//        visited.add(node);
//
//        for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
//            if (!visited.contains(neighbor)) {
//                Order(map, visited, order, neighbor);
//            }
//        }
//        order.add(node);
//    }
//
//    private boolean checkCycles(Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> recStack, int node) {
//        if (recStack.contains(node)) {
//            return true; // detects cycle
//        }
//        if (visited.contains(node)) {
//            return false; // represents that no cycle found in this path or something
//        }
//
//        visited.add(node);
//        recStack.add(node);
//
//        for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
//            if (checkCycles(map, visited, recStack, neighbor)) {
//                return true;
//            }
//        }
//
//        recStack.remove(node);
//        return false;
//    }
//
//    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites){
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (int i=0; i<prerequisites.length; i++){
//            int des = prerequisites[i][0];
//            int src = prerequisites[i][1];
//
//            map.putIfAbsent(src, new ArrayList<>());
//            map.get(src).add(des);
//
//            map.putIfAbsent(des, new ArrayList<>());
//        }
//
//        return map;
//    }
}
