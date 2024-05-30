package src;

import java.util.Queue;
import java.util.LinkedList;

public class Leetcode200 {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public static void dfs(char[][] grid, int currentRow, int currentCol) {
        if (currentRow < 0 ||
                currentCol < 0 ||
                currentRow >= grid.length ||
                currentCol >= grid[0].length ||
                grid[currentRow][currentCol] == '0') {
            return;
        }
        grid[currentRow][currentCol] = '0';
        dfs(grid, currentRow - 1, currentCol);
        dfs(grid, currentRow + 1, currentCol);
        dfs(grid, currentRow, currentCol - 1);
        dfs(grid, currentRow, currentCol + 1);
    }

    // Brute Force Method || BFS
//    public int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        boolean[][] visited = new boolean[n][m];
//
//        int count = 0;
//
//        for (int i=0; i < n; i++){
//            for(int j=0; j < m; j++){
//                if (!visited[i][j] && grid[i][j]=='1'){
//                    count++;
//                    traversal(i, j, visited, grid);
//                }
//            }
//        }
//        return count;
//    }
//
//    public void traversal(int row, int col, boolean[][] visited, char[][] grid){
//        visited[row][col] = true;
//        Queue<Integer[]> queue = new LinkedList<>();
//        queue.add(new Integer[]{row, col});
//        int n = grid.length;
//        int m = grid[0].length;
//
//        while(!queue.isEmpty()){
//            int rowOne = queue.peek()[0];
//            int colOne = queue.peek()[1];
//            queue.remove();
//
//            if (rowOne>0 && !visited[rowOne-1][colOne] && grid[rowOne-1][colOne]=='1'){
//                queue.add(new Integer[]{rowOne-1, colOne});
//                visited[rowOne-1][colOne] = true;
//            }
//            if (rowOne<n-1 && !visited[rowOne+1][colOne] && grid[rowOne+1][colOne]=='1'){
//                queue.add(new Integer[]{rowOne+1, colOne});
//                visited[rowOne+1][colOne] = true;
//            }
//            if (colOne>0 && !visited[rowOne][colOne-1] && grid[rowOne][colOne-1]=='1'){
//                queue.add(new Integer[]{rowOne, colOne-1});
//                visited[rowOne][colOne-1] = true;
//            }
//            if (colOne<m-1 &&!visited[rowOne][colOne+1] && grid[rowOne][colOne+1]=='1'){
//                queue.add(new Integer[]{rowOne, colOne+1});
//                visited[rowOne][colOne+1] = true;
//            }
//        }
//    }
}
