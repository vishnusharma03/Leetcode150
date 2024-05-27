package src;

public class Leetcode427 {

    public Node construct(int[][] grid) {

        boolean check = isSame(grid);
        boolean val = grid[0][0] == 1;
        Node node = new Node(val, check);
        if (!check){
            int midRow = grid.length/2;
            int midCol = grid[0].length/2;

            int[][] one = splitArray(grid, 0, midRow, 0, midCol);
            int[][] two = splitArray(grid, 0, midRow, midCol, grid[0].length);
            int[][] three = splitArray(grid, midRow, grid.length, 0, midCol);
            int[][] four = splitArray(grid, midRow, grid.length, midCol, grid[0].length);

            node.topLeft = construct(one);
            node.topRight = construct(two);
            node.bottomLeft = construct(three);
            node.bottomRight = construct(four);
        }
        return node;
    }

    private int[][] splitArray(int[][] grid, int startRow, int endRow, int startCol, int endCol) {
        if (startRow==endRow && startCol==endCol)
            return grid;

        int numRows = endRow - startRow;

        int[][] slice = new int[numRows][];
        for (int i = startRow; i < endRow; i++) {
            slice[i - startRow] = new int[endCol - startCol]; // Initialize inner array (Important)
            for (int j = startCol; j < endCol; j++) {
                slice[i - startRow][j - startCol] = grid[i][j];
            }
        }

        return slice;
    }

    private boolean isSame(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] != grid[0][0])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }


 // Optimized Solution
    public Node construct2(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    public Node build(int[][] grid, int r, int c, int size) {
        if (size == 1 || checkSame(grid, r, c, size)) {
            Node leaf = new Node(grid[r][c] == 1, true);
            return leaf;
        } else {
            int new_size = size/2;
            Node curr = new Node(true, false,
                    build(grid, r, c, new_size),
                    build(grid, r, c + new_size, new_size),
                    build(grid, r + new_size, c, new_size),
                    build(grid, r + new_size, c + new_size, new_size));
            return curr;
        }
    }
    public boolean checkSame(int[][] grid, int r, int c, int size) {
        int first = grid[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (grid[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
