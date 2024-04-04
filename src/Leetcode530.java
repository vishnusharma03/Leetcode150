package src;

public class Leetcode530 {

    public static void main(String[] args) {
        Leetcode530 one = new Leetcode530();
        TreeNode root = one.new TreeNode(4);
        root.left = one.new TreeNode(2);
        root.right = one.new TreeNode(6);
        root.left.left = one.new TreeNode(1);
        root.left.right = one.new TreeNode(3);

        System.out.println(one.getMinimumDifference(root));
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


    public int getMinimumDifference(TreeNode root) {
        if (root==null)
            return 0;
        int leftMin = helperLeft(root.left, 0);
        return 0;

    }

    private int helperLeft(TreeNode left, int val) {
        if (left==null)
            return val;
        int l = left.val;
        if (left.left!=null){
            helperLeft(left.left, val);
        }
        if (left.right!=null){
            if (left.right.val > val)
                val = left.right.val;
            helperLeft(left.right, val);
        }
        return val;
    }
}
