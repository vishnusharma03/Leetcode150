package src;

import java.util.Arrays;

public class Leetcode209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3}; // {12,28,83,4,25,26,25,2,25,25,25,12}; //  {1,2,3,4,5};
        int target = 7; //213; // 11
        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);

    }

    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (sum >= target) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}


// Does check the topics section in problem || Mistake102
//    private static int minSubArrayLen(int target, int[] nums) {
//
//        int s = 0;
//        int e = nums.length-1;
//        int valIndex = 0;
//        int length = Integer.MAX_VALUE;
//
//        while (s < nums.length) {
//            int[] preS = prefixSum(nums, s, e);
//            valIndex = binarySearch(target, preS, s, e);
//            if (valIndex < 0) return length;
//            if (length > valIndex+1 && preS[valIndex] >= target) {
//                length = valIndex + 1;
//            }
//            s = valIndex;
//        }
//
//        return length;
//    }
//
//    private static int[] prefixSum(int[] nums, int s, int e){
//        int[] prefixSum = new int[e-s+1];
//
//        prefixSum[0] = nums[s];
//
//        for (int i = 1; i <= e-s; i++) {
//            prefixSum[i] = prefixSum[i-1] + nums[s+i];
//        }
//        return prefixSum;
//    }
//
//
//    private static int binarySearch(int value, int[] arr, int s, int e){
////        int s = 0;
//        e = arr.length;
//        int ceiling = -1;
//
//        while (s < e){
//            int mid = s + (e-s)/2;
//            if(arr[mid] == value)
//                return mid;
//            else if (arr[mid] < value){
//                s = mid+1;
//            }else{
//                ceiling = mid;
//                e = mid-1;
//            }
//        }
//        return ceiling;
//    }
//}

// Misunderstood the definition of subarray || Mistake101
//    public static int minSubArrayLen(int target, int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for (int i = nums.length-1; i >= 0; i--) {
//            sum += nums[i];
//            if (sum >= target)
//                return nums.length-i;
//        }
//        return 0;
//    }
//}
