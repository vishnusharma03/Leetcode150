package src;


import java.util.ArrayList;

public class Leetcode230 {
    public static void main(String[] args) {
        Leetcode230 one = new Leetcode230();
        TreeNode root = one.new TreeNode(3);
        root.left = one.new TreeNode(1);
        root.right = one.new TreeNode(4);
        root.left.right = one.new TreeNode(2);

        System.out.println(one.kthSmallest(root, 2));
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        helperKthSmallest(root, k, list);
        return list.get(k - 1);
    }

    private void helperKthSmallest(TreeNode node, int k, ArrayList<Integer> list) {
        if (node == null) return;

        helperKthSmallest(node.left, k, list);
        list.add(node.val);
        if (list.size() == k) return;
        helperKthSmallest(node.right, k, list);
    }
}


    // Brute Force, Beats 99% in memory but 43% in time.
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> list = new ArrayList<>();
//        helperKthSmallest(root, k, list);
//        return list.get(k-1);
//    }
//
//    private void helperKthSmallest(TreeNode node, int k, ArrayList<Integer> list) {
//        if (node==null) return;
//
//        helperKthSmallest(node.left, k, list);
//        list.add(node.val);
//        if (list.size()==k) return;
//        helperKthSmallest(node.right, k, list);
//
//    }
//}
