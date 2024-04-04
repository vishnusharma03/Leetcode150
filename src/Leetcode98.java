package src;


import java.util.ArrayList;
import java.util.List;

public class Leetcode98 {

    public static void main(String[] args) {
        Leetcode98 one = new Leetcode98();
        TreeNode root = one.new TreeNode(-2147483648);
        root.left = one.new TreeNode(-2147483648);


        System.out.println(one.isValidBST(root));
    }

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

    public boolean isValidBST(TreeNode root) {
        List<Integer> a = new ArrayList<>();
        return inorderTraversal(root, a);
    }

    public boolean inorderTraversal(TreeNode node, List<Integer> a){

        if (node==null)
            return true;

        boolean one = inorderTraversal(node.left, a);

        if (!a.isEmpty() && a.getLast() >= node.val){
            return false;
        }
        a.add(node.val);

        boolean two = inorderTraversal(node.right, a);

        return one && two;
    }

}
