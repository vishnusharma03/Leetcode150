package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(Arrays.toString(ans.getFirst().toArray()));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {

            if (i == 0 || nums[i] != nums[i-1]) {

                int j = i+1;
                int k = nums.length - 1;

                while(j < k) {

                    if(nums[i] + nums[j] + nums[k] == 0) {

                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        j++;

                        while(j < k && nums[j] == nums[j-1]) j++;
                    }
                    else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}

// Well 3Sum is Hard.
