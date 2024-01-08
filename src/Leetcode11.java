package src;

public class Leetcode11 {
    public static void main(String[] args) {
        int[] height = {10,9,8,7,6,5,4,3,2,1};
        int ans = maxArea(height);
        System.out.println(ans);
    }

    private static int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int result = totalWater(height, s, e);

        while (s < e) {
            result = Math.max(result, totalWater(height,s,e));
            if (height[s] <= height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return result;
    }

    private static int totalWater(int[] height, int s, int e){
        return Math.min(height[s], height[e]) * (e-s);
    }
}

//    private static int maxArea(int[] height) {
//        int s = 0;
//        int e = height.length - 1;
//        int result = totalWater(height, s, e);
//        int sI = 0;
//        while (s < e){
//            if (s+sI+1 >= height.length) break;
//            if (height[s] <= height[e]){// && result < totalWater(height, s+1+sI, e)){
//                if (result < totalWater(height, s+1+sI, e)) {
//                    result = totalWater(height, s+1+sI, e);
//                    s += sI + 1;
//                    sI = 0;
//                }else {
//                    sI++;
//                }
//            } else {
//                if (result < totalWater(height, s, e - 1 - sI)) {
//                    result = totalWater(height, s, e - 1 - sI);
//                    e = e - 1 - sI;
//                }else
//                    sI++;
//            }
//        }
//
//        return result;
//    }


    // Brute Force Method
//    public static int maxArea(int[] height) {
//        int s = 0;
//        int e = height.length - 1;
//        int result = totalWater(height, s, e);
//        while (s < e){
//            if (result < totalWater(height,s+1, e)) {
//                s++;
//                result = totalWater(height, s, e);
//            }
////            else if (result < totalWater(height, s, e - 1)) {
////                e--;
////                result = totalWater(height, s , e);
////            }
//            else {
//                e--;
////                result = totalWater(height, s, e);
//            }
//        }
//        return result;
//    }


