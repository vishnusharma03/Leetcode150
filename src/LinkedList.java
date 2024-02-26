package src;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;
    private void Node(){
        this.size = 0;
    }

    public void addFirstNode(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail==null) tail= head;

        size++;
    }

    public void addLast(int val){
        if (tail==null) {
            addFirstNode(val);
            return;
        }
        ListNode temp = new ListNode(val);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public void addAtPos(int position, int val){
        if (head == null){
            addFirstNode(val);
            return;
        }
        if (position == size){
            addLast(val);
            return;
        }
        ListNode temp = head;
        for (int i = 0; i < position-1; i++) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(val, temp.next);
        temp.next = newNode;

        size++;
    }

    public void display(){

        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " ->");
            temp = temp.next;
        }
        System.out.println("Ended");
    }

    private class ListNode {

        private int val;
        private ListNode next;

        private ListNode(int val) {
            this.val = val;
        }
        private ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
