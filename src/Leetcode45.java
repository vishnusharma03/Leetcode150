package src;

public class Leetcode45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4}; //{2,3,0,1,4};
        int ans = jump(nums);
        System.out.println(ans);
    }

    public static int jump(int[] nums) {
        int steps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                steps++;
                currentEnd = farthest;
            }
        }

        return steps;
    }
}
//    public static int jump(int[] nums) {
//        int jf = 0;
//        int jt = nums[jf];
//        int steps = 0;
//        if (jt >= nums.length-1)
//            return steps;
//
//        while (jt < nums.length-1){
//            int cI = jf;
//            int maxElement = cI + nums[jf + 1];
//            int maxIndex = jf + 1;
//            for (int j = jf+1; j <= jt; j++) {
//                if (cI + j + nums[j] > maxElement) {
//                    maxElement = nums[j];
//                    maxIndex = j;
//                }
//            }
//
//            steps++;
//            jf = maxIndex;
//            jt = nums[jf];
//
//        }
//    return steps;
//    }
//}
