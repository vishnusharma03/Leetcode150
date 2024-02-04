package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static src.Leetcode56.merge;

public class Leetcode57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}}; //{{1, 2}, {3, 10}, {12, 16}}; //{{1, 3}, {6, 9}}; //  //
        int[] newInterval = {6, 8};
        int[][] ans = insert(intervals, newInterval);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;


        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
//    private static int[][] insert(int[][] intervals, int[] newInterval) {
//        if (intervals.length == 0)
//            return new int[][]{newInterval};
//        int sp = 0;
//        int ep = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][1] < newInterval[0])
//                sp = i+1;
//            if (intervals[i][0] > newInterval[1])
//                ep = i-1;
//        }
//
//        // Insertion
//        List<List<Integer>> ans = new ArrayList<>();
//
//        int index = 0;
//        while (index < sp){
//            List<Integer> inner = new ArrayList<>();
//            inner.add(intervals[index][0]);
//            inner.add(intervals[index][1]);
//            ans.add(inner);
//            index++;
//        }
//        List<Integer> inner = new ArrayList<>();
//        inner.add(Math.min(newInterval[0], intervals[sp][0]));
//        inner.add(Math.max(newInterval[1], intervals[ep][1]));
//        ans.add(inner);
//
//        index++;
//        for (int j = ep+1; j < intervals.length; j++) {
//            List<Integer> innerOne = new ArrayList<>();
//            innerOne.add(intervals[j][0]);
//            innerOne.add(intervals[j][1]);
//            ans.add(innerOne);
//            index++;
//        }
//        int[][] array = ans.stream()
//                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
//                .toArray(int[][]::new);
//        return array;
//    }
//}
    // Solution is correct.
    //  Printing extra space as the size gets reduced if merged.
//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int sp = 0;
//        int ep = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][1] < newInterval[0])
//                sp = i+1;
//            if (intervals[i][0] > newInterval[1])
//                ep = i;
//        }
//
//        // Insertion
//        int[][] ans = new int[intervals.length+1][2];
//        int index = 0;
//        while (index < sp){
//            ans[index][0] = intervals[index][0];
//            ans[index][1] = intervals[index][1];
//            index++;
//        }
//        ans[index][0] = Math.min(newInterval[0], intervals[sp][0]);
//        ans[index][1] = Math.max(newInterval[1], intervals[ep-1][1]);
//
//        index++;
//        for (int j = ep; j < intervals.length; j++) {
//            ans[index][0] = intervals[j][0];
//            ans[index][1] = intervals[j][1];
//            index++;
//        }
//        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(ans));
//
//        int size = list.size();
//
//        for(int i = size-1; i >= 0; i--) {
//            if(ans[i][0] == 0 && ans[i][1] == 0) {
//                list.remove(i);
//            }
//        }
//
//        return list.toArray(new int[0][0]);
//    }
//}

    // Brute Force Method
//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int position = 0;
//        for (int i = 0; i < intervals.length-1; i++) {
//            if (intervals[i][1] < newInterval[0] || intervals[i+1][0] > newInterval[1]) {
//                position = i+1;
//            }
//        }
//        int[][] ans = new int[intervals.length+1][2];
//        int  i = 0;
//        while (i < position){
//            ans[i][0] = intervals[i][0];
//            ans[i][1] = intervals[i][1];
//            i++;
//        }
//        ans[i][0] = newInterval[0];
//        ans[i][1] = newInterval[1];
//
//        for (int j = i+1; j < intervals.length+1; j++) {
//            ans[j][0] = intervals[j-1][0];
//            ans[j][1] = intervals[j-1][1];
//        }
//
//        return merge(ans);
//    }
//}
