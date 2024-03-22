package src;

import java.util.*;

public class Leetcode295 {

    public static void main(String[] args) {
        Leetcode295 one = new Leetcode295();
        MedianFinder obj = one.new MedianFinder();
        obj.addNum(-1);
        System.out.println("Median after adding -1: " + obj.findMedian());
        obj.addNum(-2);
        System.out.println("Median after adding -2: " + obj.findMedian());
        obj.addNum(-3);
        System.out.println("Median after adding -3: " + obj.findMedian());
        obj.addNum(-4);
        System.out.println("Median after adding -4: " + obj.findMedian());
        obj.addNum(-5);
        System.out.println("Median after adding -5: " + obj.findMedian());
    }

    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else minHeap.add(num);

            if (maxHeap.size() >= minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() >= maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            } else return (double) maxHeap.peek();
        }
    }
}

    // Brute Force Method
//    class MedianFinder {
//        List<Integer> list;
//
//        public MedianFinder() {
//            list = new ArrayList<>();
//        }
//
//        public void addNum(int num) {
//            this.list.add(num);
//        }
//
//        public double findMedian() {
//            int n = list.size();
//            if (n==1) return (double) list.getFirst();
//            list.sort(Comparator.naturalOrder());
//            int mid = (n / 2);
//            if ((n & 1) == 1) {
//                return (double) list.get(mid);
//            }
//            return (double) (list.get(mid) + list.get(mid - 1))/2;
//        }
//    }
//}
