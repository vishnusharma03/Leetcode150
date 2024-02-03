package src;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,6};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int s = 0;
        int e = 0;
        while (e < nums.length){
            if (e < nums.length-1 && nums[e]+1 == nums[e+1]){
                e++;
            }else {
                if(e-s==0)
                    list.add(String.valueOf(nums[e]));
                else {
                    list.add(nums[s] + "->" + nums[e]);
                }
                e++;
                s = e;
            }
        }

        return list;
    }
}
