package src;

public class Leetcode42 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1}; //{4,2,0,3,2,5};
        int ans = trap(nums);
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        return 0;
    }
}

//    public static int trap(int[] height) {
////        int trackSum = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            if (height[i] < height[i-1]){
//                int j = i+1;
//                int im = 1;
//                while(height[j] < height[i-1]){
//                    im += height[i-1] - height[j]; //im++;
//                    j++;
//                    if (j == height.length-1 && height[i]>=height[j]){
//                        im = 0;
//                        break;
//                    }
//                }
//                trackSum += im;
//            }
//        }
//
//        return height.length > 1 ? trackSum - 1 : trackSum;
//    }
//}
