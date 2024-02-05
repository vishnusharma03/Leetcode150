package src;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {
    public static void main(String[] args) {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}; // {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}; //{{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the points based on their end value
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the arrow position,
            // it means we need a new arrow for this balloon
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}


    // Brute Force Method

//    private static int findMinArrowShots(int[][] points) {
//        Arrays.sort(points, (a, b) -> {
//            if (a[0] == b[0]) {
//                return Integer.compare(a[1], b[1]);
//            } else {
//                return Integer.compare(a[0], b[0]);
//            }
//        });
//        int count = 1;
//        int[] check = points[0];
//        int i = 0;
//        while (i < points.length){
//            if (check[1] >= points[i][0]){
//                check = overlap(check, points[i]);
//            }else {
//                count++;
//                check = points[i];
//            }
//            i++;
//        }
//
//        return count;
//    }
//
//    private static int[] overlap(int[] check, int[] point) {
//        int[] ans = new int[check.length];
//        ans[0] = Math.max(check[0], point[0]);
//        ans[1] = Math.min(check[1], point[1]);
//        return ans;
//    }
//}


    // Error 101
//    public static int findMinArrowShots(int[][] points) {
//      Arrays.sort(points, (a, b) -> {
//            if (a[0] == b[0]) {
//                return Integer.compare(a[1], b[1]);
//            } else {
//                return Integer.compare(a[0], b[0]);
//            }
//        });
//        for (int i = 0; i < points.length; i++) {
//            System.out.println(Arrays.toString(points[i]));
//        }
//        int i = 0;
//        int j = 1;
//        int count = 0;
//        while (j < points.length){
//            if (!overlaps(points, i, j)){
//                count++;
//                i = j;
//            }
//            j++;
//        }
//        return count+1;
//    }
//
//    private static boolean overlaps(int[][] points, int i, int j) {
//        if (points[i][1] >= points[j][0])
//            return true;
//        return false;
//    }
//}
// Try optimizing the solution.