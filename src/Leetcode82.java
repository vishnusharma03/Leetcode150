package src;

public class Leetcode82 {
    public static void main(String[] args) {
        Leetcode82 sv = new Leetcode82();
        ListNode head = sv.new ListNode(1);
        ListNode one = sv.new ListNode(2);
        ListNode two = sv.new ListNode(2);
        ListNode three = sv.new ListNode(2);

        head.next = one;
        one.next = two;
        two.next = three;

        sv.display(head);
        System.out.println();
        sv.display(sv.deleteDuplicates(head));

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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (prev.next != head) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}


    // Error 101
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head==null || head.next==null) return head;
//
//        ListNode x = head;
//        int flag = 0;
//        while(x!=null && x.next!=null && x.val==x.next.val){
//            x = x.next;
//            flag=1;
//        }
//        if (flag==1)
//            head = x.next;
//
//
//        if (head==null || head.next==null) return head;
//
//        ListNode temp = head;
//        ListNode first = head.next;
//        ListNode second = head.next.next;
//
//        while(temp.next!=null){
//            if(temp.next!=null && first.val == second.val){
//                temp.next = second.next;
//                first = first.next.next;
//                if (second.next!=null)
//                    second = second.next.next;
//                else second=null;
//
//
//            }else{
//                temp = temp.next;
//                first = first.next;
//                if (second!=null)
//                    second = second.next;
//            }
//        }
//        return head;
//    }
//}
