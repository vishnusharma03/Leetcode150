package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> list = combine(n, k);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    // Optimized Way || Label R
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, result);
            path.removeLast();
        }
    }
}

    // Brute Force Method
//    public static List<List<Integer>> combine(int n, int k) {
//        List<Integer> pro = new ArrayList<>();
//        List<Integer> unpro = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            unpro.add(i+1);
//        }
//        return helper(pro, unpro, k);
//    }
//
//    private static List<List<Integer>> helper(List<Integer> pro, List<Integer> unpro, int k) {
//        if (pro.size()==k){
//            List<List<Integer>> ans = new ArrayList<>();
//            ans.add(pro);
//            return ans;
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int i = 0; i < unpro.size(); i++) {
//            List<Integer> y = new ArrayList<>(pro);
//            y.add(unpro.get(i));
//
//            List<Integer> z = new ArrayList<>(unpro.subList(i+1,unpro.size()));
//
//            List<List<Integer>> x = helper(y, z, k);
//            result.addAll(x);
//        }
//        return result;
//    }
//}
