package src;

import javax.lang.model.util.Elements;
import java.util.Arrays;

public class Leetcode4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}; //{3};
        int[] nums2 = {2}; //{-2,-1};
        Leetcode4 solution = new Leetcode4();
        double ans = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    // Will Search for Optimized Method. || Status: Pending...
    // Brute Force Method
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = mergeSortedArrays(nums1, nums2);
        int len = ans.length;
        int mid = (len - 1) / 2;
        double result = 0.0;
        if ((len & 1) == 1) {
            result = (ans[mid]);
        } else result = (double) (ans[mid] + ans[mid + 1]) / 2;
        return result;
    }
    private int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int left = nums1.length-1;
        int right = 0;

        while (left >= 0 && right < nums2.length && nums1[left] > nums2[right]){
            swap(nums1, nums2, left, right);
            left--;
            right++;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = Arrays.copyOf(nums1, nums1.length+nums2.length);
        int j = 0;
        for (int i = nums1.length; i < ans.length; i++) {
            ans[i] = nums2[j];
            j++;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static void swap(int[]  nums1, int[] nums2, int left, int right) {
        int temp = nums1[left];
        nums1[left] = nums2[right];
        nums2[right] = temp;
    }
}

//    public static void mergeSortedArrays(int[] arr1, int[] arr2, int n, int m) {
//
//        // len of the imaginary single array:
//        int len = n + m;
//
//        // Initial gap:
//        int gap = (len / 2) + (len % 2);
//
//        while (gap > 0) {
//            // Place 2 pointers:
//            int left = 0;
//            int right = left + gap;
//            while (right < len) {
//                // case 1: left in arr1[]
//                //and right in arr2[]:
//                if (left < n && right >= n) {
//                    swapIfGreater(arr1, arr2, left, right - n);
//                }
//                // case 2: both pointers in arr2[]:
//                else if (left >= n) {
//                    swapIfGreater(arr2, arr2, left - n, right - n);
//                }
//                // case 3: both pointers in arr1[]:
//                else {
//                    swapIfGreater(arr1, arr1, left, right);
//                }
//                left++; right++;
//            }
//            // break if iteration gap=1 is completed:
//            if (gap == 1) break;
//
//            // Otherwise, calculate new gap:
//            gap = (gap / 2) + (gap % 2);
//        }

    // Error 102
//    private int[] mergeSortedArrays(int[] nums1, int[] nums2){
//        int gap = (nums1.length + nums2.length)/2 + (nums1.length + nums2.length)%2;
//        int n = nums1.length;
//        int m = nums2.length;
//        while (gap > 0) {
//            int left = 0;
//            int right = left + gap;
//            while (right <= (n + m)) {
//                if (left < n && right >= n) {
//                    if (nums1[left] > nums2[right-n])
//                        swap(nums1, nums2, left, right-n);
//                } else if (left > n) {
//                    if (nums2[left-n] > nums2[right-n])
//                        swap(nums2, nums2, left-n, right-n);
//                } else {
//                    if (nums1[left] > nums2[right])
//                        swap(nums1, nums1, left, right);
//                }
//                left++;
//                right++;
//            }
//            if (gap==1) break;
//            gap = gap/2 + gap%2;
//        }
//        int[] ans = Arrays.copyOf(nums1, nums1.length+nums2.length);
//        int j = 0;
//        for (int i = nums1.length; i < ans.length; i++) {
//            ans[i] = nums2[j];
//            j++;
//        }
//        System.out.println(Arrays.toString(ans));
//        return ans;
//    }
//}
