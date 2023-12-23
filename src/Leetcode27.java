import java.util.Arrays;
import java.util.stream.IntStream;

public class Leetcode27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int x;
        x = removeElement(nums,val);
        System.out.println("K is "+ x);
    }

//    public static int removeElement(int[] nums, int val) {
//
//        int[] finalNums = nums;
//        int[] finalNums1 = nums;
//        nums = IntStream.range(0, nums.length).filter(i -> finalNums[i] != val).map(i -> finalNums1[i]).toArray();
//        System.out.println(Arrays.toString(nums));
//        return nums.length;
//    }

    public static int removeElement(int[] nums, int val) {
        int k = 0; // Represents the number of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
