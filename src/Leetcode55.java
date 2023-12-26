package src;

public class Leetcode55 {
    public static void main(String[] args) {
        int[] nums = {};
        boolean x = canJump(nums);
        System.out.println(x);
    }
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

//    public static boolean canJump(int[] nums) {
//        int jt = 0;
//        int jf = 0;
//        if (nums[jf] == 0)
//            return false;
//        while (jt < nums.length - 1) {
//            if (jt >= nums.length - 1) {
//                return true;
//            }
//            jt += nums[jt];
//
//            if (nums[jt] == 0) {
//                int stuckindex = jt;
//                int i = 1;
//                int id = jt;
//                while (jt <= stuckindex) {
//                    if (id == jf) {
//                        return false;
//                    }
//                    jt = jt - i + nums[jt - i];
//                    i++;
//                    id--;
//                }
////                jt = i;
//            }
//        }
//        return true;
//    }
//    public static boolean canJump(int[] nums) {
//
//        int n = nums.length;
//
//        int jf = 0; // jump from
//        int jt = 0; // jump to
//
//        for(int i = 0; i <= jf && jf < n; i++) {
//
//            // update jt as far as possible
//            if(jf + nums[jf] >= n - 1) {
//                return true;
//            }
//
//            jt = Math.max(jt, jf + nums[jf]);
//
//            if(i == jf) {
//                int prev = jf;
//                jf = jt;
//
//                // if stuck, reset
//                if(prev == jf) {
//                    return false;
//                }
//            }
//
//        }
//        return false;
//    }
//    public static boolean canJump(int[] nums) {
//        int jf = 0;
//        int jt = nums[jf];
//
//        while(jt <= nums.length-1){
//            if(jt>=nums.length-1){
//                return true;
//            }
//            jf = jt;
//            jt += nums[jf];
//            while(nums[jt]==0 && jt-1 > jf){
//                jt += nums[jt-1] - 1;
//            }
//        }
//        return false;
//    }

//}
