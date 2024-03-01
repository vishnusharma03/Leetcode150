package src;

import java.util.HashMap;

public class Leetcode138 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr!=null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

    // Error 101
//    public Node copyRandomList(Node head) {
////        HashMap<Node, Node> map = new HashMap<>();
//
//        Node original1 = head;
////        Node original2 = head;
//
//        Node answer = new Node(original1.val);
//        original1 = original1.next;
//        ;
//
//        Node ans1 = answer;
////        Node ans2 = answer;
//
//        int i = 1;
//        while (original1 != null) {
//
//            Node one = new Node(original1.val);
//            ans1.random = new Node(original1.random.val);
//            ans1.next = one;
//            ans1 = ans1.next;
//            original1 = original1.next;
//
//        }
//        return answer;
//    }
//}
