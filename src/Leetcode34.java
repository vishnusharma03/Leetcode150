package src;

import java.util.Arrays;

public class Leetcode34 {
    public static void main(String[] args) {
        int[] nums = {2,2}; //{5,7,7,8,8,10};
        int target = 2;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {

        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while (s <= e){
            int mid = s + (e-s)/2;
            if (nums[mid] == target)
                ans = mid;
            if (nums[mid] < target)
                s = mid + 1;
            else e = mid-1;
        }
        return findAnswer(nums, ans);
    }

    private static int[] findAnswer(int[] nums, int index){
        if (index==-1) return new int[]{-1,-1};
        int idOne = index;
        int firstI = index;
        int finalI = index;
        if (index-1 > 0) {
            while (index > -1 && nums[index] == nums[index - 1]) {
                firstI--;
                index--;
            }
        }
        if (idOne+1 < nums.length){
        while (idOne < nums.length-1 && nums[idOne] == nums[idOne + 1]) {
                idOne++;
                finalI++;
            }
        }
        return new int[]{firstI, finalI};
    }
}
