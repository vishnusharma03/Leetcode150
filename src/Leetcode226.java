package src;

public class Leetcode226 {
    public static void main(String[] args) {
        Leetcode226 sv = new Leetcode226();
        int[] nodes = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = sv.new TreeNode(nodes[0]); // Root node with value 4

        for (int i = 1; i < nodes.length; i++) {
            sv.insertIntoBST(root, nodes[i]);
        }

//        sv.display(root);
        sv.display(sv.invertTree(root));
    }

    public void display(TreeNode root) {
        displayHelper(root, 0, "Root: ");
    }

    private void displayHelper(TreeNode node, int level, String prefix) {
        if (node == null) {
            return;
        }

        // Print the current node
        System.out.println(getIndentString(level) + prefix + node.val);

        // Recursively display the left and right subtrees
        displayHelper(node.left, level + 1, "L--- ");
        displayHelper(node.right, level + 1, "R--- ");
    }

    private String getIndentString(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("     "); // 5 spaces for each level of depth
        }
        return sb.toString();
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode ans = new TreeNode(root.val);

        helperInvert(root, ans);

        return ans;
    }

    private void helperInvert(TreeNode root, TreeNode ans) {
        if (root.left != null){
            ans.right = new TreeNode(root.left.val);
            helperInvert(root.left, ans.right);
        }
        if (root.right != null){
            ans.left = new TreeNode(root.right.val);
            helperInvert(root.right, ans.left);
        }
    }
}
