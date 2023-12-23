import java.util.Arrays;

public class Leetcode189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
    }
    static void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
//    public static void rotate(int[] nums, int k) {
//        while(k>0) {
//            int temp = nums[nums.length-1];
//            for (int i = 0; i < nums.length-1; i++) {
//                nums[nums.length-i-1] = nums[nums.length-i-2];
//            }
//            nums[0] = temp;
//            k--;
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
