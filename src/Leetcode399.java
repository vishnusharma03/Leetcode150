package src;

import java.util.*;


public class Leetcode399 {
    public static void main(String[] args) {

    }

    class Edge {
        String dest;
        double weight;

        public Edge(String dest, double weight){
            this.dest = dest;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> map = buildGraph(equations, values);
        int qrySize = queries.size();
        double[] ans = new double[qrySize];

        for (int i = 0; i < qrySize; i++) {
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), map);
        }
        return ans;
    }

    public double dfs(String src, String des, HashSet<String> visited, Map<String, List<Edge>> map){
        if (!map.containsKey(src) || !map.containsKey(des)) {
            return -1;
        }
        if (src.equals(des))
            return 1;
        visited.add(src);
        for (Edge e : map.get(src)){
            if (!visited.contains(e.dest)) {
                double ans = dfs(e.dest, des, visited, map);
                if (ans != -1)
                    return ans * e.weight;
            }
        }
        return -1;
    }

    public Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, List<Edge>> adj = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).getFirst();
            String dest = equations.get(i).get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.putIfAbsent(dest, new ArrayList<>());
            adj.get(src).add(new Edge(dest, values[i]));
            adj.get(dest).add(new Edge(src, 1/values[i]));
        }
        return adj;
    }

}