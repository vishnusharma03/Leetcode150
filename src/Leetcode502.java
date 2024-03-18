package src;

import java.util.PriorityQueue;

public class Leetcode502 {
    public static void main(String[] args) {
        Leetcode502 one = new Leetcode502();
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(one.findMaximizedCapital(k, w, profits, capital));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll()[1];
        }
        return w;
    }
}
