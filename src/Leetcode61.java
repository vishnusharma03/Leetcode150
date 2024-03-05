package src;

public class Leetcode61 {

    public static void main(String[] args) {
        Leetcode61 sv = new Leetcode61();

        ListNode head = sv.new ListNode(1);
        ListNode current = head;  // Start with the head node
        for (int i = 2; i <= 5; i++) {  // Iterate for values 2 to 5
            ListNode newNode = sv.new ListNode(i);
            current.next = newNode;  // Link the current node to the new node
            current = newNode;  // Move to the newly created node
        }
        sv.display(head);
        System.out.println();
        sv.display(sv.rotateRight(head, 2));

    }

    public void display(ListNode X) {
        ListNode currentNode = X;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");  // Print the current node's value
            currentNode = currentNode.next;  // Move to the next node
        }
        System.out.println();
    }

    // Definition for singly-linked list.
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return head;
        ListNode temp = head;
        int size = 1;

        while(temp.next!=null){
            temp = temp.next;
            size++;
        }
        temp.next = head;

        int i = 1;
        int rotate = k%size;
        while(i <= size-rotate){
            temp = temp.next;
            head = head.next;
            i++;
        }
        temp.next = null;

        return head;
    }
}
