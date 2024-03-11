package src;

public class Leetcode100 {
    public static void main(String[] args) {
        Leetcode100 sv = new Leetcode100();
        // Constructing tree 'p'
        TreeNode p = sv.new TreeNode(10);
        p.left = sv.new TreeNode(5);
        p.right = sv.new TreeNode(15);

        // Constructing tree 'q'
        TreeNode q = sv.new TreeNode(10);
        q.left = sv.new TreeNode(5);
        q.right = sv.new TreeNode(); // This node is a placeholder for the 'null' value
        q.left.left = sv.new TreeNode(); // This node is a placeholder for the 'null' value
        q.left.right = sv.new TreeNode(); // This node is a placeholder for the 'null' value
        q.right.right = sv.new TreeNode(15);


        System.out.println(sv.isSameTree(p, q));
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p == null) return false;
        if(q == null) return false;
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
