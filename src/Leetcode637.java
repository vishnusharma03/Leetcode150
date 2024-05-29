package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Leetcode637 {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if (root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int levelsize = queue.size();
            double sum = 0;

            for(int i=0; i < levelsize; i++){
                TreeNode one = queue.poll();
                sum += one.val;

                if (one.left!=null){
                    queue.add(one.left);
                }

                if (one.right!=null){
                    queue.add(one.right);
                }
            }
            double avg = sum/levelsize;
            ans.add(avg);
        }
        return ans;
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

}
