package src;


public class Leetcode108 {
    public static void main(String[] args) {
        Leetcode108 one = new Leetcode108();
        int[] nums = {-10,-3,0,5,9};
        TreeNode x = one.sortedArrayToBST(nums);
        one.printInorder(x);
    }

    public void printInorder(TreeNode node){
        if (node==null)
            return;

        printInorder(node.left);
        System.out.println(node.val + " ");
        printInorder(node.right);
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

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();

        return helperBST(root, 0, nums.length-1,nums);
    }

    public TreeNode helperBST(TreeNode node, int sI, int eI, int[] nums){
        if (sI > eI)
            return node;

        int mid = sI + (eI-sI)/2;
        node = new TreeNode(nums[mid]);
        node.left = helperBST(node.left, sI, mid-1, nums);
        node.right = helperBST(node.right, mid+1, eI, nums);
        return node;
    }
}
