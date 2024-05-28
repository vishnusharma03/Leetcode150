package src;

public class Leetcode236 {
    public static void main(String[] args) {
        Leetcode236 one = new Leetcode236();
        TreeNode root = one.new TreeNode(3);
        TreeNode node5 = one.new TreeNode(5);
        TreeNode node1 = one.new TreeNode(1);
        TreeNode node6 = one.new TreeNode(6);
        TreeNode node2 = one.new TreeNode(2);
        TreeNode node0 = one.new TreeNode(0);
        TreeNode node8 = one.new TreeNode(8);
        TreeNode node7 = one.new TreeNode(7);
        TreeNode node4 = one.new TreeNode(4);

        // Constructing the tree
        root.left = node5;
        root.right = node1;

        node5.left = node6;
        node5.right = node2;

        node1.left = node0;
        node1.right = node8;

        node2.left = node7;
        node2.right = node4;

        // Identifying p and q
        TreeNode p = node5;  // Node with value 5
        TreeNode q = node4;  // Node with value 4

        TreeNode lca = one.lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("LCA: " + lca.val);
        } else {
            System.out.println("LCA not found");
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;

        if (root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null) return root;

        return left!=null ? left : right;
    }


    // Error
    // public TreeNode traversal(TreeNode root, TreeNode p, TreeNode q){
    //     if (root!=null){
    //         // System.out.print(root.val + " ");
    //         if (root==p){
    //             return p;
    //         }
    //         if(root==q){
    //             return q;
    //         }
    //         // prev = root;
    //         TreeNode ans = traversal(root.left, p, q);
    //         TreeNode ans2 = traversal(root.right, p, q);

    //         return ans && ans2;

    //     }
    //     return null;
    // }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
