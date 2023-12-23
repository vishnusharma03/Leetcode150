import java.util.Arrays;

import static java.util.Collections.swap;

public class Leetcode88 {
    public static void main(String[] args) {
        int[] nums1 = {0,0,3,0,0,0,0,0,0}; //{1,2,3,0,0,0};//
        int[] nums2 = {-1,1,1,1,2,3}; //{2,5,6}; //
        merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        m -= 1;
        n -= 1;

        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }

        // Copy remaining elements from nums2 if any
        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
    }

}
