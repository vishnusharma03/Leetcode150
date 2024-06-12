package src;

import java.util.Queue;

public class Leetcode909 {
    public static void main(String[] args) {

    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        boolean[] visited = new boolean[target + 1];
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == target) return moves;

                for (int j = 1; j <= 6 && curr + j <= target; j++) {
                    int next = curr + j;
                    int[] coordinates = getCoordinates(next, n);
                    int nextRow = coordinates[0];
                    int nextCol = coordinates[1];

                    int dest = board[nextRow][nextCol] == -1 ? next : board[nextRow][nextCol];

                    if (!visited[dest]) {
                        queue.offer(dest);
                        visited[dest] = true;
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;
        if (row % 2 == 1) col = n - 1 - col;
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
