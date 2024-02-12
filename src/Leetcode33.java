package src;

import java.util.Arrays;
import static java.util.Arrays.binarySearch;

public class Leetcode33 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2}; // {4, 5, 6, 7, 0, 1, 2}; // {1,3}; {1,3,5}; //
        int target = 2;
        System.out.println(search(nums, target));
    }

//    public static int search(int[] nums, int target){
//
//
//
//        return 0;
//    }
//
//}
    // Time Limit Exceeded
    public static int search(int[] nums, int target){
        int s = 0;
        int e =nums.length-1;
        int pivot = pivotSearch(nums);
        if (pivot == -1)
            return binarySearch(nums, 0, nums.length-1, target);
        if (pivot < nums.length && nums[pivot] == target)
            return pivot;
        if (nums[0] <= target)
            return binarySearch(nums, s, pivot-1, target);
        return binarySearch(nums, pivot+1, e, target);
    }

    private static int binarySearch(int[] ints, int s, int e, int target) {
        while (s <= e){
            int mid = s + (e - s) / 2;

            if (ints[mid] ==  target)
                return mid;
            else if (ints[mid] < target)
                s = mid+1;
            else e = mid-1;
        }
        return -1;
    }

    public static int pivotSearch(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid < e && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (mid > s && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[s] >= nums[mid])
                s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}

 //  Error 101
//    public static int search(int[] nums, int target) {
////        if (nums.length==0) return 0;
////        if (nums.length==1) {
////            if (nums[0] == target)
////                return 0;
////            else return -1;
////        }
//        int s = 0;
//        int e = nums.length-1;
//        while (s < e) {
//            int mid = s + (e - s) / 2;
//            if (nums[mid] > nums[mid + 1]) {
//                int x = binarySearch(nums, s, mid, target);
//                if (x > -1) return x;
//                int y = binarySearch(nums, mid + 1, e, target);
//                if (y > -1) return y;
//            } else {
//                search(Arrays.copyOf(nums, mid), target);
//                search(Arrays.copyOfRange(nums, mid + 1, e), target);
//            }
//        }
//        return -1;
//    }
//}
