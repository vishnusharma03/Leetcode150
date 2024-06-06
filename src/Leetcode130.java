package src;

import java.util.Arrays;

public class Leetcode130 {
    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
                };

        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }

    // Optimized Method
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];
        for(int i=0; i<m; i++){
            if(board[i][0]=='O' && (vis[i][0]!=1)){
                vis[i][0]=1;
                dfs(board, vis, i, 0);
            }
            if(board[i][n-1]=='O' && (vis[i][n-1]!=1)){
                vis[i][n-1]=1;
                dfs(board, vis, i, n-1);
            }
        }
        for(int j=0; j<n; j++){
            if(board[0][j]=='O' && (vis[0][j]!=1)){
                vis[0][j]=1;
                dfs(board, vis, 0, j);
            }
            if(board[m-1][j]=='O' && (vis[m-1][j]!=1)){
                vis[m-1][j]=1;
                dfs(board, vis, m-1, j);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((board[i][j]=='O') && (vis[i][j]!=1)){
                    board[i][j]='X';
                }
            }
        }
    }
    private static void dfs(char[][] board, int[][] vis, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(i==m || j==n){
            return;
        }
        if(isValid(i+1, j, m, n) && (board[i+1][j]=='O') && (vis[i+1][j]!=1)){
            vis[i+1][j]=1;
            dfs(board, vis, i+1, j);
        }
        if(isValid(i, j+1, m, n) && (board[i][j+1]=='O') && (vis[i][j+1]!=1)){
            vis[i][j+1]=1;
            dfs(board, vis, i, j+1);
        }
        if(isValid(i-1, j, m, n) && (board[i-1][j]=='O') && (vis[i-1][j]!=1)){
            vis[i-1][j]=1;
            dfs(board, vis, i-1, j);
        }
        if(isValid(i, j-1, m, n) && (board[i][j-1]=='O') && (vis[i][j-1]!=1)){
            vis[i][j-1]=1;
            dfs(board, vis, i, j-1);
        }
        return;
    }
    private static boolean isValid(int i, int j, int m, int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }

    // Brute Force
//    public static void solve(char[][] board) {
//        if (board.length <= 2)
//            return;
//
//        int n = board.length;
//        int m = board[0].length;
//
//        boolean[][] visited = new boolean[n][m];
//
//
//        // Traverse the top row
//        for (int j = 0; j < m; j++) {
//            System.out.println("Top row: (" + 0 + ", " + j + ")");
//            if (!visited[0][j] && board[0][j] == 'O'){
//                dfs(0, j, visited, board);
//            }
//        }
//
//        // Traverse the bottom row
//        for (int j = 0; j < m; j++) {
//            System.out.println("Bottom row: (" + (n - 1) + ", " + j + ")");
//            if (!visited[n-1][j] && board[n-1][j] == 'O'){
//                dfs(n-1, j, visited, board);
//            }
//        }
//
//        // Traverse the left column
//        for (int i = 1; i < n - 1; i++) {
//            System.out.println("Left column: (" + i + ", " + 0 + ")");
//            if (!visited[i][0] && board[i][0] == 'O'){
//                dfs(i, 0, visited, board);
//            }
//        }
//
//        // Traverse the right column
//        for (int i = 1; i < n - 1; i++) {
//            System.out.println("Right column: (" + i + ", " + (m - 1) + ")");
//            if (!visited[i][m-1] && board[i][m-1] == 'O'){
//                dfs(i, m-1, visited, board);
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 'O' && !visited[i][j]) {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
//
//    public void dfs(int r, int c, boolean[][] visited, char[][] board){
//        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c]=='X' || visited[r][c])
//            return;
//
//        visited[r][c] = true;
//
//
//        dfs(r-1, c, visited, board);
//        dfs(r+1, c, visited, board);
//        dfs(r, c-1, visited, board);
//        dfs(r, c+1, visited, board);
//    }

    // Error
//    public static void solve(char[][] board) {
//        if (board.length<=2)
//            return;
//
//        int n = board.length;
//        int m = board[0].length;
//
//        for (int r = 1; r < n-1; r++){
//            for(int c = 1; c < m-1; c++){
//                if (board[r][c]=='O'){
//                    boolean left = check("left", r, c, board);
//                    boolean right = check("right", r, c, board);
//                    boolean up = check("up", r, c, board);
//                    boolean down = check("down", r, c, board);
//                    if (left && right && up && down)
//                        board[r][c]='X';
//                }
//            }
//        }
//    }
//
//    private static boolean check(String direction, int r, int c, char[][] board){
//        int n = board.length;
//        int m = board[0].length;
//
//        if (direction=="left"){
//            while(c > 0){
//                c--;
//                if (board[r][c]=='X')
//                    return true;
//            }
//            return false;
//        }
//
//        if (direction=="right"){
//            while(c < n-1){
//                c++;
//                if (board[r][c]=='X')
//                    return true;
//            }
//            return false;
//        }
//
//        if (direction=="up"){
//            while(r > 0){
//                r--;
//                if (board[r][c]=='X')
//                    return true;
//            }
//            return false;
//        }
//
//        if (direction=="down"){
//            while(r < m-1){
//                r++;
//                if (board[r][c]=='X')
//                    return true;
//            }
//            return false;
//        }
//        return false;
//    }
}
