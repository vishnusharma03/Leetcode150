package src;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Leetcode128 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1}; //{0,3,7,2,5,8,4,6,0,1}; //{100,4,200,1,3,2}; //
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {

        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }

        int maxLength = 0;

        for (int num : map) {
            if (!map.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (map.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }


}
    // Error
//    private static int longestConsecutive(int[] nums) {
//        ConcurrentHashMap<Integer, List<Integer>> map = new ConcurrentHashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], new ArrayList<>());
//                map.get(nums[i]).add(nums[i]);
//
//            }
//        }
//        System.out.println(map);
//        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, List<Integer>> entry = iterator.next();
//            previousExist(map.get(entry.getKey()), map);
//            forwardExist(map.get(entry.getKey()), map);
//        }
////        System.out.println(map);
//        return 0;
//    }
//
//    private static void forwardExist(List<Integer> integers, ConcurrentHashMap<Integer, List<Integer>> map) {
//        int sTwo = integers.getFirst() + (Integer)1;
//        if (map.containsValue(sTwo+1)) {
//            map.get(sTwo).add(sTwo + 1);
//            map.remove(sTwo + 1);
//            forwardExist(Collections.singletonList(sTwo - 2), map);
//            System.out.println(10);
//        }
//        System.out.println(map);
//    }
//
//    private static void previousExist(List<Integer> integers, ConcurrentHashMap<Integer, List<Integer>> map) {
//        int sOne = integers.getFirst();
//
//        if (map.containsValue(sOne-1)) {
//            map.get(sOne).add(sOne - 1);
//            map.remove(sOne-1);
//            previousExist(Collections.singletonList(sOne - 2), map);
//        }
//
//    }
//
//}


    // Brute Force Method || Exceeds O(n) complexity
//    public static int longestConsecutive(int[] nums) {
//        if (nums.length == 0) return 0;
//        Arrays.sort(nums);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int k = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsValue(nums[i])){
//                map.put(k, nums[i]);
//            k++;
//            }
//        }
//        int f = 0;
//        int j = 1;
//        int maxLength = 0;
//        int currentLength = 0;
//        while(j < map.size()){
//            if(iscosecutive((int)map.get(j-1),(int)map.get(j))){
//                currentLength = j - f;
//                if (currentLength>maxLength)
//                    maxLength = currentLength;
//            }else{
//                currentLength = 0;
//                f = j;
//            }
//            j++;
//        }
//        return maxLength+1;
//    }
//
//    private static boolean iscosecutive(int i, int j) {
//        if (i + 1 == j)
//            return true;
//        return false;
//    }
//}
