package src;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode215 {
    public static void main(String[] args) {
        Leetcode215 one = new Leetcode215();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6}; //{3,2,1,5,6,4};
        int k = 4;
        System.out.println(one.findKthLargest(nums, k));
    }

    // Optimized Method
    public int findKthLargest(int[] nums, int k) {
        int[] freq = new int[20001];
        for (int num : nums) {
            ++freq[num + 10000];
        }

        for (int i = freq.length - 1; i >= 0; --i) {
            k -= freq[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        throw new IllegalArgumentException();
    }
}

    // Brute Force Method
//    public int findKthLargest(int[] nums, int k) {
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (Integer num: nums){
//            pq.add(num);
//        }
//
//        int ans = 0;
//        for (int i = 0; i < k; i++) {
//            ans = pq.remove();
//        }
//    return ans;
//    }
//}
