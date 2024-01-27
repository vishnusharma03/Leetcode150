package src;

import java.util.*;

import static src.Leetcode242.isAnagram;

public class Leetcode49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

// Well, one needs to apply OOPs concepts to achieve >90% efficiency.

    // Brute Force Method
//    private static List<List<String>> groupAnagrams(String[] strs) {
//        String[] sOne = strs.clone();
//        for (int i = 0; i < sOne.length; i++) {
//            sOne[i] = sortString(strs[i]);
//        }
//
//        Map<String, List<Integer>> multimap = new HashMap<>();
//        for (int i = 0; i < sOne.length; i++) {
//            addValue(multimap, sOne[i], i);
//        }
//        List<List<String>> result = new ArrayList<>();
//
//        for (List<Integer> valueList : multimap.values()) {
//            List<String> tempList = new ArrayList<>();
//            for (Integer index : valueList) {
//                tempList.add(strs[index]);
//            }
//            result.add(tempList);
//        }
//
//        return result;
//    }
//    public static String sortString(String str) {
//        char[] charArray = str.toCharArray();
//        Arrays.sort(charArray);
//        return new String(charArray);
//    }
//    private static void addValue(Map<String, List<Integer>> map, String key, Integer value) {
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
//    }
//}



// Hell of the unsuccessful trials
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<Integer, String> multimap = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            multimap.put(i, strs[i]);
//        }
//        System.out.println(multimap);
////       ArrayList<Integer> index = new ArrayList<>();
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            result.add(new ArrayList<>());
//        }
//        for (int i = 0; i < multimap.size(); i++) {
//            for (int j = i+1; j < multimap.size(); j++) {
//                String sOne = multimap.get(i);
//                String sTwo = multimap.get(j);
//                if (isAnagram(sOne, sTwo)) {
//                    if (!result.get(i).contains(sOne)) result.get(i).add(sOne);
//                    if (!result.get(i).contains(sTwo)) result.get(i).add(sTwo);
//                }
//            }
//        }
//
//
        // Arraylist Declaration
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            result.add(new ArrayList<>());
//        }
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            map.put(strs[i], i);
//        }
//        System.out.println(map);
//        for (int i = 0; i < strs.length; i++) {
//            for (int j = i + 1; j < strs.length; j++) {
//                if (isAnagram(strs[i], strs[j])) {
//                    map.put(strs[j], map.get(strs[i]));
//                }
//            }
//        }
//        Set<Integer> uniqueValues = new HashSet<>(map.values());
//
//        Object[] res = uniqueValues.toArray();
//
//        for (int i = 0; i < res.length; i++) {
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                if (entry.getValue() == res[i]){
//                    result.get(i).add(entry.getKey());
//                }
//            }
//        }
//        result.removeIf(List::isEmpty);
//        return result;
//    }
//
//    private static void addValue(Map<Integer, List<String>> map, Integer key, String value) {
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
//    }
//}