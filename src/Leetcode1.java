package src;

import java.util.*;

public class Leetcode1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        map.put(0, new ArrayList<>());
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < target)
//                map.get(0).add(nums[i]);
//        }
//
//        Object[] arr = Arrays.stream(map.get(0).toArray()).sorted().toArray();
//        System.out.println(Arrays.toString(arr));
//        int l = 0;
//        int r = arr.length-1;
//
//        while (l <= r){
//            int element = (Integer) arr[l];
//            int last = (Integer) arr[r];
//            if (element + last == target)
//                return new int[]{l,r};
//            else if (element + last < target) {
//                l++;
//            }else
//                r--;
//        }
//        return new int[]{-1,-1};
//    }
//}
