package src;


import java.util.HashMap;

public class Leetcode106 {
    public static void main(String[] args) {
        Leetcode106 sv = new Leetcode106();
        int[] inorder = {1, 2};
        int[] postorder = {2, 1};
        TreeNode root = sv.buildTree(inorder, postorder);
        System.out.print("Inorder : ");
        sv.printInOrder(root);

        System.out.println();
        System.out.print("Postorder: ");
        sv.printPostorder(root);
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

    public void printPostorder(TreeNode node) {
        if (node == null) return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.val + " ");
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int[] index = {postorder.length-1};

        return helperBuild(inorder, postorder, 0, index[0], map, index);
    }

    private TreeNode helperBuild(int[] inorder, int[] postorder, int left, int right, HashMap<Integer, Integer> map, int[] index) {
        if (left>right)
            return null;

        int current = postorder[index[0]];
        TreeNode currentNode = new TreeNode(current);
        index[0]--;

        if (left==right)
            return currentNode;

        int inorderIndex = map.get(current);

        currentNode.right = helperBuild(inorder, postorder, inorderIndex+1, right, map, index);

        currentNode.left = helperBuild(inorder, postorder, left, inorderIndex-1, map, index);
        // This relative order took me 2 hrs to fix the array out of bounds error.
        return currentNode;
        }
    }

