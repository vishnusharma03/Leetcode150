package src;

public class Leetcode35{
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {

        if (target < nums[0]) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while (start <= end) {

            mid = start + (end-start) / 2;

            int midElement = nums[mid];

            if (midElement == target) {
                return mid;
            }
            else if (midElement < target) {
                if (mid+1 == nums.length || nums[mid+1] > target) return mid+1;
                start = mid + 1;
            } else {
                if (nums[mid-1] < target) return mid;
                end = mid - 1;
            }
        }

        return mid;
    }
}
