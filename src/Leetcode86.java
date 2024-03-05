package src;

public class Leetcode86 {

    public static void main(String[] args) {
        Leetcode86 sv = new Leetcode86();
        ListNode head = sv.new ListNode(1);
        ListNode one = sv.new ListNode(4);
        ListNode two = sv.new ListNode(3);
        ListNode three = sv.new ListNode(2);
        ListNode four = sv.new ListNode(5);
        ListNode five = sv.new ListNode(2);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        sv.display(head);
        System.out.println();
        sv.display(sv.partition(head, 3));

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

    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode ans = new ListNode(0);
        ListNode anstemp = ans;

        while(temp!=null){
            if (temp.val < x){
                anstemp.next = new ListNode(temp.val);
                anstemp = anstemp.next;
            }
            temp = temp.next;
        }
        display(ans);
        temp = head;
        while(temp!=null){
            if (temp.val >= x){
                anstemp.next = new ListNode(temp.val);
                anstemp = anstemp.next;
            }
            temp = temp.next;
        }
        display(ans);
        return ans.next;
    }
}
