//package src;
//
//public class ListNode {
//    private ListNode head;
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//
//    public void appendLast(int val){
//        ListNode temp = head;
//        ListNode newNode = new ListNode(val);
//        if (head == null){
//            head = temp;
//        }
//        while (temp.next != null){
//            temp = temp.next;
//        }
//        temp.next = newNode;
//
//    }
//
//
//    public void display(){
//        ListNode temp = head;
//        while (temp != null){
//            System.out.print(temp.val + " ->");
//            temp = temp.next;
//        }
//        System.out.println("Ended");
//    }
////    public ListNode get(int position){
////        ListNode temp = head;
////        for (int i = 1; i < position; i++) {
////            temp = temp.next;
////        }
////
////    }
//
//    public ListNode append(ListNode head, int value) {
//        ListNode newNode = new ListNode(value);
//        if (head == null) {
//            // If the list is empty, the new node becomes the head
//            return newNode;
//        }
//        ListNode current = head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = newNode;
//        return head;
//    }
//
////    public void addFirstNode(int val){
////        ListNode node = new ListNode(val);
////        node.next = ListNode;
////        ListNode = node;
////
////        if (tail==null) tail= head;
////
////        size++;
////    }
//
//}
//
//
////package src;
////
////public class ListNode {
////    public Node head;
////    public Node tail;
////    private int size;
////    static void Node(){
////        this.size = 0;
////    }
////
////
////    public Node nextOne(Node temp){
////        temp = temp.next;
////        return temp;
////    }
////
////    public void addFirstNode(int val){
////        Node node = new Node(val);
////        node.next = head;
////        head = node;
////
////        if (tail==null) tail= head;
////
////        size++;
////    }
////
////    public void addLast(int val){
////        if (tail==null) {
////            addFirstNode(val);
////            return;
////        }
////        Node temp = new Node(val);
////        tail.next = temp;
////        tail = temp;
////        size++;
////    }
////
////    public void addAtPos(int position, int val){
////        if (head == null){
////            addFirstNode(val);
////            return;
////        }
////        if (position == size){
////            addLast(val);
////            return;
////        }
////        Node temp = head;
////        for (int i = 0; i < position-1; i++) {
////            temp = temp.next;
////        }
////
////        Node newNode = new Node(val, temp.next);
////        temp.next = newNode;
////
////        size++;
////    }
////
////    public void display(){
////
////        Node temp = head;
////        while (temp != null){
////            System.out.print(temp.val + " ->");
////            temp = temp.next;
////        }
////        System.out.println("Ended");
////    }
////
////    public class Node {
////
////        private int val;
////        private Node next;
////
////        private Node(int val) {
////            this.val = val;
////        }
////        private Node(int val, Node next){
////            this.val = val;
////            this.next = next;
////        }
////    }
////}
