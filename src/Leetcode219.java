package src;

import java.util.*;

import static java.lang.Math.abs;

public class Leetcode219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int sOne = map.get(nums[i]);
                if (Math.abs(i - sOne) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;

    }
}

//Error 101
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i]))
//                map.put(nums[i], new ArrayList<>());
//            map.get(nums[i]).add(i);
//        }
//        for (int i = 0; i < map.size(); i++) {
//            Object[] sOne = map.get(nums[i]).toArray();
//            for (int j = 0; j < sOne.length; j++) {
//                for (int l = 0; l < sOne.length; l++) {
//                    if (j != l && nums[j]==nums[l] && Math.abs((int)sOne[j]-(int)sOne[l]) <= k){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
