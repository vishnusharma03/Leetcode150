import java.util.Arrays;

public class Leetcode169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }
    public static int majorityElement(int[] nums) {
        int a = 0;
        int x = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1 || nums[i] != nums[i + 1]) {
                if (i - a > a) {
                    a = i - a;
                    x = i;
                }
            }
        }
        return nums[x];
    }
}
