package src;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode105 {

    public static void main(String[] args) {
        Leetcode105 sv = new Leetcode105();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode ans = sv.buildTree(pre, in);
        sv.printInOrder(ans);
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


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] index = {0};
        return helper(preorder, inorder, 0, preorder.length-1, map, index);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map, int[] index){
        if (left > right)
            return null;

        int current = preorder[index[0]];
        TreeNode currentNode = new TreeNode(current);
        index[0]++;

        if (left==right){
            return currentNode;
        }

        int inorderIndex = map.get(current);

        currentNode.left = helper(preorder, inorder, left, inorderIndex-1, map, index);
        currentNode.right = helper(preorder, inorder, inorderIndex+1, right , map, index);

        return currentNode;
    }

//    private void helperTree(TreeNode node, int[] preorder, HashMap<Integer, Integer> map, int i) {
//        if (i== preorder.length)
//            return;
//
//        if (map.get(node.val) > map.get(preorder[i])){
//            node.left = new TreeNode(preorder[i]);
//            helperTree(node.left, preorder, map, i+1);
//        }
//        if (map.get(node.val) < map.get(preorder[i])){
//            node.right = new TreeNode(preorder[i]);
//            helperTree(node.right, preorder, map, i+1);
//        }
//    }

}
