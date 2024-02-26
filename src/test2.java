package src;

import java.util.Arrays;
import java.util.HashMap;

public class test2 {

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,1};
        int[] nums2 = {2,3,4,6};
//        int[] nums = mergeit(nums1, nums2);
//        System.out.println(Arrays.toString(nums));
        System.out.println(isPossibleToSplit(nums1));
    }

    public static boolean isPossibleToSplit(int[] nums) {
        if ((nums.length & 1)==1)
            return false;
        boolean flag = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//            System.out.println(map.get(nums[i])==3);
            if (map.get(nums[i])==3)
                return !flag;
        }
        return flag;
    }

    private static int[] mergeit(int[] nums1, int[] nums2) {
        int left = nums1.length-1;
        int right = 0;

        while (nums1[left] > nums2[right]){
            swap(nums1, nums2, left, right);
            left--;
            right++;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
        int[] ans = Arrays.copyOf(nums1, nums1.length+nums2.length);
        int j = 0;
        for (int i = nums1.length; i < ans.length; i++) {
            ans[i] = nums2[j];
            j++;
        }
        return ans;
    }

    private static void swap(int[]  nums1, int[] nums2, int left, int right) {
        int temp = nums1[left];
        nums1[left] = nums2[right];
        nums2[right] = temp;
    }


}
