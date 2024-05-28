package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public static void main(String[] args) {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int levelsize = queue.size();
            TreeNode one = null;
            for (int i = 0; i <levelsize; i++) {
                one = queue.poll();

                if (one.left!=null){
                    queue.add(one.left);
                }
                if (one.right!=null){
                    queue.add(one.right);
                }
            }
            ans.add(one.val);
        }
        return ans;
    }

    // Optimized [Revise]
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new LinkedList<>();
//        getRightSideViewUsingReversePreeOrderTraversal(root,0,result);
//        return result;
//    }
//
//    private void getRightSideViewUsingReversePreeOrderTraversal(TreeNode root,int level,List<Integer> ds){
//        if(root ==null){
//            return;
//        }
//
//        if(level == ds.size()){
//            ds.add(root.val);
//        }
//
//        getRightSideViewUsingReversePreeOrderTraversal(root.right,level+1,ds);
//        getRightSideViewUsingReversePreeOrderTraversal(root.left,level+1,ds);// if right side doesnot exist so we will consider left side
//    }

    // Brute Force Method
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        int height = height(root);
//        return helper(root, root, ans, height);
//    }
//
//    public List<Integer> helper(TreeNode root, TreeNode node, List<Integer> ans, int height){
//        int size = ans.size();
//        if (node!=null && size<height){
//            int level = findLevel(root, node, 1);
//            System.out.print("Level: " + level + " , val: "+ node.val);
//            if (level > size)
//                ans.add(node.val);
//            helper(root, node.right, ans, height);
//            helper(root, node.left, ans, height);
//        }
//        return ans;
//    }
//
//    public int height(TreeNode root){
//        if (root==null) return 0;
//        return 1 + Math.max(height(root.left), height(root.right));
//    }
//
//    public int findLevel(TreeNode root, TreeNode target, int level) {
//        if (root == null) {
//            return 0;
//        }
//        if (root == target) {
//            return level;
//        }
//
//        int leftLevel = findLevel(root.left, target, level + 1);
//        if (leftLevel != 0) {
//            return leftLevel;
//        }
//
//        return findLevel(root.right, target, level + 1);
//    }

}
