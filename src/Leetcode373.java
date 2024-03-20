package src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373{
    public static void main(String[] args) {
        Leetcode373 one = new Leetcode373();
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        System.out.println(one.kSmallestPairs(nums1, nums2, k));
    }

    class Pair {
        int num1;
        int num2;
        int index2;

        public Pair(int num1, int num2, int index2) {
            this.num1 = num1;
            this.num2 = num2;
            this.index2 = index2;
        }
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.num1 + p.num2));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new Pair(nums1[i], nums2[0], 0));
        }

        while (!minHeap.isEmpty() && k-- > 0) {
            Pair pair = minHeap.poll();
            List<Integer> currPair = new ArrayList<>();
            currPair.add(pair.num1);
            currPair.add(pair.num2);
            result.add(currPair);

            if (pair.index2 + 1 < nums2.length) {
                minHeap.offer(new Pair(pair.num1, nums2[pair.index2 + 1], pair.index2 + 1));
            }
        }

        return result;
    }
}

//public class Leetcode373 {
//    public static void main(String[] args) {
//        Leetcode373 one = new Leetcode373();
//        int[] nums1 = {1,7,11};
//        int[] nums2 = {2,4,6};
//        int k = 3;
//        System.out.println(one.kSmallestPairs(nums1, nums2, k));
//    }
//
//    public class Pair{
//        int first;
//        int second;
//        int sum;
//
//        public Pair(int f, int s){
//            this.first = f;
//            this.second = s;
//            this.sum = f + s;
//        }
//        public void display(){
//            System.out.println("[" + first + ", " + second + "]");
////            System.out.println(second);
//        }
//    }
//
//    public class PairComperaor implements Comparator<Pair> {
//        public int compare(Pair a, Pair b){
//            return Integer.compare(a.sum, b.sum);
//        }
//    }
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        PriorityQueue<Pair> heap = new PriorityQueue<>(new PairComperaor());
//        while (!heap.isEmpty() && k-- > 0) {
//            Pair current = heap.poll();
//            ans.add(List.of(nums1[current.first], nums2[current.second]));
//
//            if (current.second + 1 < nums2.length) {
//                Pair nextPair = new Pair(current.first, current.second + 1, nums1[current.first] + nums2[current.second + 1]);
//                if (heap.size() < k) {
//                    // If heap is not full, add directly
//                    heap.add(nextPair);
//                } else if (nextPair.sum < heap.peek().sum) {
//                    // If heap is full, compare sum with current maximum and replace if smaller
//                    heap.poll();
//                    heap.add(nextPair);
//                }
//            }
//        }
////        for (int j : nums1) {
////            for (int value : nums2) {
////                heap.add(new Pair(j, value));
////            }
////        }
////        for (int i = 0; i < k && !heap.isEmpty(); i++) {
////            Pair x = heap.poll();
////            ans.add(List.of(x.first, x.second));
////        }
//        return ans;
//    }
//}
