package src;

import java.util.Arrays;

public class   Leetcode167 {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        int[] ans = twoSum(numbers, target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = binarysearch(numbers, target);
        while (l <= r){
            if (numbers[l] + numbers[r] == target)
                return new int[]{l+1,r+1};
            else if (numbers[l] + numbers[r] < target) {
                l++;
            }else
                r--;
        }
        return new int[]{-1,-1};
    }
    private static int binarysearch(int[] numbers, int  target) {
        int s = 0;
        int e = numbers.length-1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (numbers[mid] == target || (numbers[mid] < target && numbers[mid + 1] > target)) {
                return mid;
            } else if (numbers[mid] < target) {
                s = mid+1;
            } else
                e = mid-1;

        }
        return s==0 ? 0 : numbers.length-1;
    }
}


// Perfectly Working Brute Force Method
//    public static int[] twoSum(int[] numbers, int target) {
//        int aTIndex = binarysearch(numbers, target);
//        for (int i = 0; i <= aTIndex; i++) {
//            for (int j = i+1; j <= aTIndex; j++) {
//                if (numbers[i] + numbers[j] == target)
//                    return Arrays.stream(new int[]{i+1,j+1}).sorted().toArray();
//            }
//        }
//        return new int[]{1, 2};
//    }
//
//    private static int binarysearch(int[] numbers, int  target) {
//        int s = 0;
//        int e = numbers.length-1;
//        while (s < e) {
//            int mid = s + (e - s) / 2;
//            if (numbers[mid] == target || (numbers[mid] < target && numbers[mid + 1] > target)) {
//                return mid;
//            } else if (numbers[mid] < target) {
//                s = mid+1;
//            } else
//                e = mid-1;
//
//        }
//        return s==0 ? 0 : numbers.length-1;
//    }
//}
