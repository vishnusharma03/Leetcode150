package src;

public class Leetcode222 {
    public static void main(String[] args) {
        // Create a tree & call the function if you want to test.
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


    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int[] count = {0};
        return helperCount(root, count);
    }

    public int helperCount(TreeNode node, int[] count){
        if (node.left==null && node.right!=null){
            count[0]++;
            return count[0] + 1;
        }

        count[0]++;

        if (node.left!=null)
            helperCount(node.left, count);

        if (node.right!=null)
            helperCount(node.right, count);

        return count[0];
    }

}
