package src;

import java.util.Arrays;

public class Leetcode162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; //{6, 5, 4, 3, 2, 3, 2};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left side or mid is the peak
                right = mid;
            } else {
                // Peak is on the right side
                left = mid + 1;
            }
        }

        return left;
    }
}


    // Brute Force Method
//    private static int findPeakElement(int[] nums) {
//        if (nums.length==2){
//            if (nums[0] < nums[1])
//                return 1;
//        }
//        int index = nums[0];
//        for (int i = 1; i < nums.length-1; i++) {
//            if (nums[i] > nums[i+1] && nums[i] > nums[i-1])
//                //index = i;
//                return i;
//        }
//        if (nums[nums.length-1] > nums[nums.length-2])
//            return nums.length-1;
//        return 0;
//    }
//}


    // Error 102
//    private static int findPeakElement(int[] nums) {
//        if (nums.length==1){
//            return ;
//        }
//        int s = 0;
//        int e = nums.length-1;
//
//        int mid = s + (e-s)/2;
//
//        if ((nums[mid] > nums[mid+1]) && nums[mid] > nums[mid-1])
//            return mid;
//        else if (nums[mid] < nums[mid + 1])
//            return findPeakElement(Arrays.copyOfRange(nums, mid, e));
//        else return findPeakElement(Arrays.copyOfRange(nums, s, mid));
//    }
//}


    // Error 101
//    public static int findPeakElement(int[] nums) {
//        int e = nums.length - 1;
//        int s = 0;
//        if (nums.length==1) return 0;
//        if (nums.length==2){
//            if (nums[0] > nums[1])
//                return 0;
//            else return 1;
//        }
//        while (s < e){
//            int mid = s + (e-s)/2;
//            if ((nums[mid] > nums[mid+1]) && nums[mid] > nums[mid-1]){
//                return mid;
//            } else if (nums[mid] < nums[mid + 1]) {
//                s = mid;
//            }else e = mid;
//        }
//        return 0;
//    }
//}
