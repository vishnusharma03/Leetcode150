package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> list = permute(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> unpro = new ArrayList<>();
        for (int num : nums){
            unpro.add(num);
        }
        helper(new ArrayList<>(), unpro, result);
        return result;
    }

    private static void helper(List<Integer> pro, List<Integer> unpro, List<List<Integer>> result) {
        if (unpro.isEmpty()){
            result.add(new ArrayList<>(pro));
            return;
        }
        for (int i = 0; i < unpro.size(); i++) {
            pro.add(unpro.remove(i));
            helper(pro, unpro, result);
            unpro.add(i, pro.remove(pro.size() - 1));
        }
    }
}


// Beats 52% of Java Users
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> unpro = new ArrayList<>();
//        for (int num : nums){
//            unpro.add(num);
//        }
//        helper(new ArrayList<>(), unpro, result);
//        return result;
//    }
//
//    private static void helper(List<Integer> pro, List<Integer> unpro, List<List<Integer>> result) {
//        if (unpro.isEmpty()){
//            result.add(pro);
//            return;
//        }
//        for (int i = 0; i < unpro.size(); i++) {
//            List<Integer> sOne = new ArrayList<>(pro);
//            sOne.add(unpro.get(i));
//            List<Integer> sTwo = new ArrayList<>(unpro);
//            sTwo.remove(i);
//            helper(sOne, sTwo, result);
//        }
//    }
//}



    // Failed Attempt to find an optimized solution
//  public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        int[] pro = new int[nums.length];
//        helper(pro, nums, result);
//        return result;
//    }
//
//    private static void helper(int[] pro, int[] nums, List<List<Integer>> result) {
//        if (nums.length==0){
//            List<Integer> ans = new ArrayList<>();
//            for (int i = 0; i < pro.length; i++) {
//                ans.add(pro[i]);
//            }
//            result.add(ans);
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int[] sOne = Arrays.copyOf(pro, pro.length + 1);
//            sOne[sOne.length-1] = nums[i];
//            System.out.println("SOne" + Arrays.toString(sOne));
//
//            int[] sTwo = Arrays.copyOf(Arrays.copyOfRange(nums, 0, i), nums.length-1);
//            System.arraycopy(nums, i, sTwo, i-1, nums.length-i);
//            System.out.println("STwo" + Arrays.toString(sTwo));
//
//            helper(sOne, sTwo, result);
//        }
//    }
//    }
//
