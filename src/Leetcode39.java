package src;

import java.util.*;

public class Leetcode39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> list = combinationSum(candidates, target);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        coincomp(ans, l, candidates, target, 0);
        return ans;
    }

    public static void coincomp(List<List<Integer>> ans, List<Integer> l, int[] arr, int sum, int idx) {
        if (sum == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (sum >= arr[i]) {
                l.add(arr[i]);
                coincomp(ans, l, arr, sum - arr[i], i);
                l.removeLast();
            }
        }
    }
}

//      Brute Force Method
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> map = new ArrayList<>();
//        helperCombinationSum(new ArrayList<>(), candidates, target, map, 0);
//        return new ArrayList<>(map);
//    }
//
//    private static void helperCombinationSum(List<Integer> processed, int[] candidates, int target, List<List<Integer>> map, int start) {
//        int sum = processed.stream().mapToInt(Integer::intValue).sum();
//
//        if (sum == target){
//            map.add(new ArrayList<>(processed));
//            return;
//        }
//        if (sum > target){
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            processed.add(candidates[i]);
//            helperCombinationSum(processed, candidates, target, map, i);
//            processed.removeLast();
//        }
//    }
//}

//     Correct Solution but also incorporating duplicates.
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> processed = new ArrayList<>();
//        helperCombinationSum(processed, candidates, target, result);
//        return result;
//    }
//
//    private static void helperCombinationSum(List<Integer> processed, int[] candidates, int target, List<List<Integer>> result) {
//        int sum = processed.stream().mapToInt(Integer::intValue).sum();
//
//        if (sum == target){
//            result.add(new ArrayList<>(processed));
//        }
//        if (sum > target){
//            return;
//        }
//        for (int candidate : candidates) {
//            processed.add(candidate);
//            helperCombinationSum(processed, candidates, target, result);
//            processed.removeLast();
//        }
//    }
//}
