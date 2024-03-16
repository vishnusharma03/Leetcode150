package src;

import java.util.*;

public class Leetcode173 {
    public static void main(String[] args) {
        Leetcode173 one = new Leetcode173();
        TreeNode root = one.new TreeNode(7);
        root.left = one.new TreeNode(3);
        root.right = one.new TreeNode(15);
        root.right.left = one.new TreeNode(9);
        root.right.right = one.new TreeNode(20);


        BSTIterator iterator = one.new BSTIterator(root);

        // Perform operations
        String[] operations = {"BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"};

        for (String operation : operations) {
            switch (operation) {
                case "BSTIterator":
                    // Already created iterator with root node
                    break;
                case "next":
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    } else {
                        System.out.println("No next element available.");
                    }
                    break;
                case "hasNext":
                    System.out.println(iterator.hasNext());
                    break;
                default:
                    System.out.println("Invalid operation: " + operation);
                    break;
            }
        }

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

    class BSTIterator {
        Deque<Integer> deque = new ArrayDeque<>();
        public BSTIterator(TreeNode root) {
            helperInorder(root);
        }

        private void helperInorder(TreeNode node) {
            if (node==null)
                return;

            helperInorder(node.left);
            deque.push(node.val);
            helperInorder(node.right);
        }

        public int next() {
            return deque.removeLast();
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
