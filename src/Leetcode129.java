package src;

public class Leetcode129 {
    public static void main(String[] args) {
        Leetcode129 one = new Leetcode129();
        Integer[] arr = {1,2,3};
        TreeNode root = one.createTree(arr);

        System.out.println(one.sumNumbers(root));
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

    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        int[] totalSum = {0};
        return helperSum(root, 0, 1, totalSum);
    }

    public int helperSum(TreeNode node, int currentSum, int pow, int[] totalSum){
        currentSum = currentSum*10 + node.val;
        if (node.left==null && node.right==null){
            totalSum[0] += currentSum;
            return totalSum[0];
        }
        if (node.left!=null){
            helperSum(node.left, currentSum, pow*10, totalSum);
        }
        if (node.right!=null){
            helperSum(node.right, currentSum, pow*10, totalSum);
        }

        return totalSum[0];
    }
}
