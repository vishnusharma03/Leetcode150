package src;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode117 {
    public static void main(String[] args){

        Leetcode117 one = new Leetcode117();
        // Create the nodes
        Node root = one.new Node(1);
        Node node2 = one.new Node(2);
        Node node3 = one.new Node(3);
        Node node4 = one.new Node(4);
        Node node5 = one.new Node(5);
        Node node7 = one.new Node(7);

        // Establish the left and right child relationships
        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node7;

        one.connect(root);

    }
    public Node connect(Node root) {
        if (root==null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){
            int levelsize = queue.size();
            Node pre = null;
            for(int i=0; i < levelsize; i++){
                Node one = queue.poll();

                if (pre!=null){
                    pre.next = one;
                }
                pre = one;

                if (one.left!=null){
                    queue.add(one.left);
                }
                if (one.right!=null){
                    queue.add(one.right);
                }
            }
            if (pre != null) {
                pre.next = null;
            }
        }
        return root;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

// Error101
//      public Node connect(Node root) {
//        if (root==null) return null;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        Queue<Node> ans = new LinkedList<>();
//
//        while(!queue.isEmpty()){
//            int levelsize = queue.size();
//
//            for(int i=0; i < levelsize; i++){
//                Node one = queue.poll();
//                ans.add(one);
//
//                if (one.left!=null){
//                    queue.add(one.left);
//                }
//                if (one.right!=null){
//                    queue.add(one.right);
//                }
//            }
//            ans.add(null);
//        }
//
//        // Iteration over the queue
//        Node x = ans.poll();
//        while(!ans.isEmpty()){
//            Node y = ans.poll();
//            x.next = y;
//            x = y;
//        }
//
//        return root;
//    }
//    public Node connect(Node root) {
//        if (root==null) return null;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            int levelsize = queue.size();
//
//            for(int i=0; i < levelsize; i++){
//                Node one = queue.poll();
//
//                if (root.left!=null){
//                    queue.add(root.left);
//                }
//                if (root.right!=null){
//                    queue.add(root.right);
//                }
//                one.next = queue.peek();
//            }
//            // one.next = null;
//        }
//        return root;
//    }
