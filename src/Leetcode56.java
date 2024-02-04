package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Leetcode56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    // Optimized method but copied.
    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort the intervals based on the starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) { // Overlapping intervals, move the end if needed
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping interval, add it to the list of merged intervals
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }
}

// Brute Force Method
//    private static int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length <= 1) {
//            return intervals;
//        }
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        // Sort intervals by their starting points
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//
//        int s = 0; // Start of the current interval
//        int e = 0; // End of the current interval, initialized to the same as start
//
//        while (s < intervals.length) {
//            int currentStart = intervals[s][0];
//            int currentEnd = intervals[s][1];
//
//            // Merge intervals if they overlap
//            while (e < intervals.length - 1 && intervals[e + 1][0] <= currentEnd) {
//                currentEnd = Math.max(currentEnd, intervals[e + 1][1]);
//                e++;
//            }
//
//            // Add the merged interval to the list
//            List<Integer> range = new ArrayList<>();
//            range.add(currentStart);
//            range.add(currentEnd);
//            list.add(range);
//
//            // Move to the next set of intervals to merge
//            e++; // Move end to the next interval
//            s = e; // Start the next interval from where end is now
//        }
//
//        // Convert List<List<Integer>> to int[][]
//        int[][] array = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            array[i][0] = list.get(i).get(0);
//            array[i][1] = list.get(i).get(1);
//        }
//
//        return array;
//    }
//}

    // CLose to the answer but should have taken one more
    // variable to take care of the index of possible answers.
//    private static int[][] merge(int[][] intervals) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        int i = 0;
//        int s = i;
//        int e = 1;
//
//        while (intervals[e][1] < intervals[intervals.length-1][1]) {
//            while (intervals[i][1] >= intervals[e][0]) {
//                e++;
//                i++;
//            }
//
//            List<Integer> range = new ArrayList<>();
//            range.add(intervals[s][0]);
//            if (s==e) {
//                range.add(intervals[e][1]);
//            }else range.add(intervals[e-1][1]);
//            s = e;
//            list.add(range);
//
//        }
//        int[][] array = list.stream()
//                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
//                .toArray(int[][]::new);
//        return array;
//    }
//
//
//}


    // After hours of debugging, logic failed.
//    public static int[][] merge(int[][] intervals) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int x = 0;
//            while(intervals[i][0]+x <= intervals[i][1]) {
//                list.add(intervals[i][0]+x);
//                x++;
//            }
//        }
//        Object[] ans = list.toArray();
//        int[] intArray = Arrays.stream(ans)
//                .mapToInt(o -> (Integer) o)
//                .toArray();
//
//        Arrays.sort(ans);
//        int[] result = Arrays.stream(intArray).distinct().toArray();
//
//        return summaryRanges(result);
//    }
//
//    public static int[][] summaryRanges(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        int s = 0;
//        int e = 0;
//
//        while (e < nums.length) {
//
//            if (e < nums.length - 1 && nums[e] + 1 == nums[e + 1]) {
//                e++;
//            } else {
//
//                List<Integer> range = new ArrayList<>();
//                if (e - s == 0) {
//                    range.add(nums[e]);
//                } else {
//                    range.add(nums[s]);
//                    range.add(nums[e]);
//                }
//
//                list.add(range);
//
//                e++;
//                s = e;
//            }
//        }
//        int[][] array = list.stream()
//                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
//                .toArray(int[][]::new);
//        return array;
//    }
//}
