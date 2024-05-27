package src;

public class Leetcode114 {
    public static void main(String[] args) {
        Leetcode114 sv = new Leetcode114();
        TreeNode root = sv.new TreeNode(1);
        root.left = sv.new TreeNode(2);
        root.right = sv.new TreeNode(5);
        root.left.left = sv.new TreeNode(3);
        root.left.right = sv.new TreeNode(4);
        root.right.right = sv.new TreeNode(6);

        sv.flatten(root);
        sv.display(root);
    }


    public void display(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            display(root.left);
            display(root.right);
        }else{
            System.out.println("null");
        }
    }

    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode ans = new TreeNode(root.val);
        ans.left = null;

        preorder(root, ans);
        root.val = ans.right.val;
        root.left = ans.left;
        root.right = ans.right.right;
    }

    public TreeNode preorder(TreeNode root, TreeNode ans){
        if (root!=null){
            ans.right = new TreeNode(root.val);
            ans.left = null;
            ans = ans.right;
            ans = preorder(root.left, ans);
            ans = preorder(root.right, ans);
        }
        return ans;
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

}
