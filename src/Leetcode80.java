import java.util.Arrays;

public class Leetcode80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int ans = rmDuplicates(nums);
        System.out.println(ans);
    }

    public static int rmDuplicates(int[] nums){
        int k = 0, i = 0;
        while(i < nums.length){
            int c  = nums[i];
            int f = 0;
            while(i < nums.length && c == nums[i]){

                if(f<2){
                    nums[k] = nums[i];
                    k++;
                    f++;
                }

                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
