package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Leetcode103 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zig = true;
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> levels = new ArrayList<>();

            for(int i=0; i < levelsize; i++){
                TreeNode node = queue.poll();
                if (zig) levels.add(node.val);
                else levels.addFirst(node.val);

                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(levels);
            zig = !zig;
        }
        return ans;
    }

    //  Definition for a binary tree node.
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
}
