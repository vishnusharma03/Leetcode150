package src;

public class Leetcode148 {
    public static void main(String[] args) {
        Leetcode148 one = new Leetcode148();
        ListNode head = one.new ListNode(-1);
        head.next = one.new ListNode(5);
        head.next.next = one.new ListNode(3);
        head.next.next.next = one.new ListNode(4);
        head.next.next.next.next = one.new ListNode(0);

        one.displayList(one.sortList(head));
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next; }
    }

    public void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }


    public ListNode sortList(ListNode head) {
        if (head.next==null)
            return head;
        ListNode mid = mid(head);
        ListNode h2 = mid.next;
        mid.next = null;
        ListNode f1 = sortList(head);
        ListNode s1 = sortList(h2);

        return merge(f1, s1);
    }

    // Optimized Merge Solution
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1!=null) temp.next = list1;
        else temp.next = list2;
        return ans.next;

    }

    // Brute Force Merge Solution
//    private ListNode merge(ListNode f1, ListNode s1) {
//        ListNode ans = new ListNode();
//        ListNode temp = ans;
//        while (f1!=null && s1!=null) {
//            if (f1.val < s1.val) {
//                temp.next = new ListNode(f1.val);
//                f1 = f1.next;
//            } else {
//                temp.next = new ListNode(s1.val);
//                s1 = s1.next;
//            }
//            temp = temp.next;
//        }
//        while (f1!=null){
//            temp.next = new ListNode(f1.val);
//            f1 = f1.next;
//            temp = temp.next;
//        }
//
//        while (s1!=null){
//            temp.next = new ListNode(s1.val);
//            s1 = s1.next;
//            temp = temp.next;
//        }
//
//        return ans.next;
//
//    }

    public ListNode mid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;

        // Error in fast & slow pointer method.
//        ListNode s = node;
//        ListNode f = node;
//
//        while (f!=null && f.next!=null){
//            s = s.next;
//            f = f.next;
//        }
//        return s;
    }
}
