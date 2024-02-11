package src;

import java.util.HashMap;

public class Leetcode149 {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}}; //{{-6,-1},{3,1},{12,3}};  //{{3,10},{0,2}}; //{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}; // //
        System.out.println(maxPoints(points));
    }

    private static int maxPoints(int[][] points) {

        if (points.length <= 1) return points.length;

        int maximum = 0; // Start with 0 to handle vertical lines

        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int count = 1; // Count the current point itself

            // Check for vertical lines
            int verticalCount = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] == x1) {
                    verticalCount++;
                }
            }
            maximum = Math.max(maximum, verticalCount + 1); // Include the current point

            // Calculate slope for non-vertical lines (if any)
            if (verticalCount < points.length - i - 1) {
                HashMap<Double, Integer> slopeCounts = new HashMap<>();
                for (int j = i + 1; j < points.length; j++) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    if (x1 == x2) continue; // Avoid comparing with itself

                    double slope = ((double) (y2 - y1) / (x2 - x1));
                    count = slopeCounts.getOrDefault(slope, 0) + 1;
                    slopeCounts.put(slope, count);
                }
                maximum = Math.max(maximum, count);
            }
        }
        return maximum;


    }
}
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
