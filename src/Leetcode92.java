package src;

public class Leetcode92 {

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

    // Optimal Solution
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null || head.next==null) return head;
        ListNode prev = null;
        ListNode temp = head;
        int i = 1;
        while (i < left-1){
            temp = temp.next;
            i++;
        }

        ListNode t1 = temp;
        ListNode t2 = temp.next;
        if (left!=1)
            temp = temp.next;

        ListNode lat = temp.next;
        i = left;

        while (i!=right+1 && temp!=null){
            temp.next = prev;
            prev = temp;
            temp = lat;
            if (lat!=null){
                lat = lat.next;
            }
            i++;
        }
        if (left!=1) {
            t2.next = temp;
            t1.next = prev;
        }else t1.next = temp;

        if (left!=1)
            return head;
        else return prev;
    }

}

    // Iteratino 2
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head==null || head.next==null) return head;
//        ListNode prev = null;
//        ListNode temp = head;
//        int i = 1;
//        while (i < left-1){
//            temp = temp.next;
//            i++;
//        }
//
//        ListNode t1 = temp;
//        ListNode t2 = temp.next;
//        if (left!=1)
//            temp = temp.next;
//
//        ListNode lat = temp.next;
//        i = left;
//
//        while (i!=right+1 && temp!=null){
//            temp.next = prev;
//            prev = temp;
//            temp = lat;
//            if (lat!=null){
//                lat = lat.next;
//            }
//            i++;
//        }
//        if (left!=1) {
//            t2.next = temp;
//            t1.next = prev;
//        }else t1.next = temp;
//
//        if (left!=1)
//            return head;
//        else return prev;
//    }



    // Working for left >=2 && right < length
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head==null || head.next==null) return head;
//        ListNode prev = null;
//        ListNode temp = head;
//        int i = 1;
//        while (i < left-1){
//            temp = temp.next;
//            System.out.println(i);
//            i++;
//        }
//
//        ListNode t1 = temp;
//        ListNode t2 = temp.next;
//        temp = temp.next;
//        ListNode lat = temp.next;
//        i = left;
//
//        while (i!=right+1 && temp!=null){
//            temp.next = prev;
//            prev = temp;
//            temp = lat;
//            if (lat!=null){
//                lat = lat.next;
//            }
//            i++;
//        }
//
//        t2.next = temp;
//        t1.next=prev;
//
//        return head;
//    }
//}
