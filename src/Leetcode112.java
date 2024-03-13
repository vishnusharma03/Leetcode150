package src;

public class Leetcode112 {
    public static void main(String[] args) {
        Leetcode112 sv = new Leetcode112();
        Integer[] arr = {1,2};
        TreeNode root = sv.createTree(arr);
//        sv.printInOrder(root);
        System.out.println(sv.hasPathSum(root, 1));

    }

    void printInOrder(TreeNode node) {
        if (node == null)
            return;

        // first recur on left child
        printInOrder(node.left);

        // then print the data of node
        System.out.print(node.val + " ");

        // now recur on right child
        printInOrder(node.right);
    }

    public TreeNode createTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        TreeNode[] nodes = new TreeNode[array.length];

        // Create all nodes
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                nodes[i] = new TreeNode(array[i]);
            }
        }

        // Assign children
        for (int i = 0; i < array.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < array.length) nodes[i].left = nodes[leftIndex];
                if (rightIndex < array.length) nodes[i].right = nodes[rightIndex];
            }
        }

        return nodes[0]; // Return the root of the tree
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helperPath(root, 0, targetSum);
    }

    public boolean helperPath(TreeNode node, int currentSum, int targetSum){
        if (node==null) {
            return false;
        }
        if (node.left==null && node.right==null && currentSum+node.val==targetSum)
            return true;

        return helperPath(node.left, currentSum+node.val, targetSum) || helperPath(node.right, currentSum+node.val, targetSum);
    }

}
