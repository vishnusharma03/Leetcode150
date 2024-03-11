package src;

public class Leetcode104 {
    public static void main(String[] args) {
        Leetcode104 sv = new Leetcode104();
        TreeNode root = sv.new TreeNode(3);
        root.left = sv.new TreeNode(9);
        root.right = sv.new TreeNode(20, sv.new TreeNode(15), sv.new TreeNode(7));
        System.out.println(sv.maxDepth(root));
    }


//  Definition for a binary tree node.
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


    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return 1 + helperDepth(root);
    }

    private int helperDepth(TreeNode root) {
        int ans = 0;
        int ans2 = 0;

        if (root.left!=null){
            ans = 1 + helperDepth(root.left);
        }
        if (root.right!=null){
            ans2 = 1 + helperDepth(root.right);
        }
        return Math.max(ans, ans2);
    }
}
