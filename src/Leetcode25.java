package src;

public class Leetcode25 {
    public static void main(String[] args) {
        Leetcode25 sv = new Leetcode25();
        ListNode head = sv.new ListNode(1);
        ListNode current = head;  // Start with the head node
        for (int i = 2; i <= 5; i++) {  // Iterate for values 2 to 5
            ListNode newNode = sv.new ListNode(i);
            current.next = newNode;  // Link the current node to the new node
            current = newNode;  // Move to the newly created node
        }

//        System.out.println(sv.size(head));
        sv.display(sv.reverseKGroup(head, 2));
    }

    public void display(ListNode X){
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


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) {
            return head;
        }

        int i = 0;
        ListNode ans = null;
        while (i < size(head)/k){
            head = reverseBetween(head,(i*k)+1,k*(i+1));
            i++;
        }
        return head;
    }

    public int size(ListNode head){
        int i = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            i++;
        }
        return i;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
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

    if (left==1)
        return prev;
    return head;
    }
}

    // Optimized Method
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head ==null){
//            return null;
//        }
//        ListNode curr =head;
//        ListNode prev = null;
//        ListNode next = null;
//        int c= k;
//        while(curr != null && c>0){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            c--;
//        }
//        if(curr == null && c>0){
//            curr = prev;
//            prev =null;
//            next = null;
//            while(curr != null)
//            {next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//        }
//        if(c > 0){
//            return prev;
//        }else{
//            head.next = reverseKGroup(curr,k);
//        }
//        return prev;
//    }
//}
