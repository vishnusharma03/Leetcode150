package src;

public class Leetcode153 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if (pivot==-1)
            return nums[0];
        return nums[pivot];
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int mid = start + (end-start)/2;
            if (mid < end && nums[mid] > nums[mid+1]){
                return mid+1;
            }
            if (mid > start && nums[mid-1] > nums[mid]){
                return mid;
            }
            if (nums[mid] > nums[start])
                start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
