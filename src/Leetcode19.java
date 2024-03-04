package src;

public class Leetcode19 {
    public static void main(String[] args) {
        Leetcode19 sv = new Leetcode19();
        ListNode head = sv.new ListNode(1);
        ListNode current = head;  // Start with the head node
        for (int i = 2; i <= 3; i++) {  // Iterate for values 2 to 5
            ListNode newNode = sv.new ListNode(i);
            current.next = newNode;  // Link the current node to the new node
            current = newNode;  // Move to the newly created node
        }
        sv.display(head);
        System.out.println();
        sv.display(sv.removeNthFromEnd(head, 2));

    }

    public void display(ListNode X){
        ListNode currentNode = X;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");  // Print the current node's value
            currentNode = currentNode.next;  // Move to the next node
        }
        System.out.println();
    }


    //Definition for singly-linked list.
        public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        int i = 1;

        while(i<=n){
            fast = fast.next;
            i++;
        }
        if (fast==null){
            return head.next;
        }
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

    // Brute Force Method
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head==null) return head;
//        int sOne = helperRemove(head, n);
//        System.out.println("Size: "+ sOne);
//        if (sOne-1==n)
//            return head.next;
//        return head;
//    }
//
//    private int helperRemove(ListNode node, int n) {
//        if (node==null)
//            return 1;
//
//        int f = helperRemove(node.next, n);
//
//        if (f == n+1) {
//            node.next = node.next.next;
//        }
//        return f+1;
//    }
//}
