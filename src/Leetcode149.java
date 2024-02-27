package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Leetcode149 {
    public static void main(String[] args) {
        Leetcode149 sv = new Leetcode149();
        int[][] points = {{1, 2}, {1, 4}, {2, 4}, {2, 1}, {3, 6}}; // {{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}}; //{{-6,-1},{3,1},{12,3}};  //{{3,10},{0,2}}; //{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}; // //
        System.out.println(sv.maxPoints(points));
    }

    // Not fully optimized. || Needs Revisit
    private int maxPoints(int[][] points) {
        if (points.length==1) return 1;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int count = 2;
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i!=j){
                    double dy = points[j][1] - points[i][1];
                    double dx = points[j][0] - points[i][0];
                    double theta = Math.atan(dy/dx);
                    map.put(theta, map.getOrDefault(theta, 1) + 1);
                    count = Math.max(map.get(theta), count);
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}


    // Brute Force Method
//    private int maxPoints(int[][] points) {
//        if (points.length==1) return 1;
//        int result = 0;
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                int count = 2;
//                double dy1 = points[j][1] - points[i][1];
//                double dx1 = points[j][0] - points[i][0];
//
//                for (int k = 0; k < points.length; k++) {
//                    if (k != i && k != j) {
//                        double dy2 = points[k][1] - points[i][1];
//                        double dx2 = points[k][0] - points[i][0];
//                        if (dy1 * dx2 == dy2 * dx1) {
//                            count++;
//                        }
//                    }
//
//                }
//                result = Math.max(result, count);
//            }
//        }
//        return result;
//    }
//}


    // Mini-Error
//    private double slope(int[] pointOne, int[] pointTwo) {
//        double x1 = pointOne[0];
//        double x2 = pointTwo[0];
//        double y1 = pointOne[1];
//        double y2 = pointTwo[1];
//
//        return (y2 - y1) / (x2 - x1);
//    }
//}


    // Error 103
//    private int maxPoints(int[][] points) {
//        if (points.length==1)
//            return 1;
//        if (points.length==2)
//            return 2;
//
//        Arrays.sort(points, Comparator.comparingDouble(o -> o[0]));
//        for (int[] point : points) {
//            System.out.println(Arrays.toString(point));
//        }
//
//        int count = 2;
//        for (int i = 0; i < points.length-1; i++) {
//            int localCount = 2;
//            for (int j = 0; j < points.length; j++) {
//                if (j==i || j==i+1)
//                    continue;
//                if (area(points[i], points[i+1], points[j]))
//                    localCount++;
//            }
//            count = Math.max(count, localCount);
//        }
//        return count;
//    }
//
//    private boolean area(int[] num1, int[] num2, int[] num3){
//        int t1 = num1[0] * (num2[1] - num3[1]);
//        int t2 = num2[0] * (num3[1] - num1[1]);
//        int t3 = num3[0] * (num1[1] - num2[1]);
//        double area = 0.5 * Math.abs(t1 + t2 + t3);
//        return area==0.0;
//    }
//}

    // Error 102
//    private static int maxPoints(int[][] points) {
//
//        if (points.length <= 1) return points.length;
//
//        int maximum = 0; // Start with 0 to handle vertical lines
//
//        for (int i = 0; i < points.length - 1; i++) {
//            int x1 = points[i][0];
//            int y1 = points[i][1];
//            int count = 1; // Count the current point itself
//
//            // Check for vertical lines
//            int verticalCount = 1;
//            for (int j = i + 1; j < points.length; j++) {
//                if (points[j][0] == x1) {
//                    verticalCount++;
//                }
//            }
//            maximum = Math.max(maximum, verticalCount + 1); // Include the current point
//
//            // Calculate slope for non-vertical lines (if any)
//            if (verticalCount < points.length - i - 1) {
//                HashMap<Double, Integer> slopeCounts = new HashMap<>();
//                for (int j = i + 1; j < points.length; j++) {
//                    int x2 = points[j][0];
//                    int y2 = points[j][1];
//                    if (x1 == x2) continue; // Avoid comparing with itself
//
//                    double slope = ((double) (y2 - y1) / (x2 - x1));
//                    count = slopeCounts.getOrDefault(slope, 0) + 1;
//                    slopeCounts.put(slope, count);
//                }
//                maximum = Math.max(maximum, count);
//            }
//        }
//        return maximum;
//    }
//}

    // Error 101
//    public static int maxPoints(int[][] points) {
//        if (points.length <= 1) return points.length;
//        int maximum = 2;
//        for (int i = 0; i < points.length - 1; i++) {
//            int x1 = points[i][0];
//            int y1 = points[i][1];
//            int x2 = points[i + 1][0];
//            int y2 = points[i + 1][1];
//            int count = 2;
//            for (int j = 0; j < points.length; j++) {
//                if (j==i || j==i+1) continue;
//                int xc = points[j][0];
//                int yc = points[j][1];
//                float slope = ((float) (y2 - y1) / (x2 - x1));
//                if (x1 != x2 && (yc - y2 == (xc - x2) * slope))
//                    count++;
//                if (x1 == x2 && xc == x2) {
//                    count++;
//                }
//                maximum = Math.max(maximum, count);
//            }
//        }
//        return maximum;
//    }
//}
