package src;

public class Leetcode101 {

    public static void main(String[] args) {
        Leetcode101 sv = new Leetcode101();
        Integer[] array = {1,2,2,3,4,4,3};
        TreeNode root = sv.createTree(array);
        System.out.println(sv.isSymmetric(root));
    }

    public TreeNode createTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        TreeNode[] nodes = new TreeNode[array.length];

        // Create all nodes
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                nodes[i] = new TreeNode(array[i]);
            }
        }

        // Assign children
        for (int i = 0; i < array.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < array.length) nodes[i].left = nodes[leftIndex];
                if (rightIndex < array.length) nodes[i].right = nodes[rightIndex];
            }
        }

        return nodes[0]; // Return the root of the tree
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


    public boolean isSymmetric(TreeNode root) {
        return helperSymmetric(root.left, root.right);
    }

    private boolean helperSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right!=null) return false;
        if (left!=null && right == null) return false;
        if (left==right) return true;

        if (left.val !=right.val) return false;
        return helperSymmetric(left.left, right.right) && helperSymmetric(left.right, right.left);

    }
}
