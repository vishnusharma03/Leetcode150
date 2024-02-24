package src;

import java.util.HashSet;

public class Leetcode141 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
//        ListNode.Node() temp = head.head;
//        while (temp != null){
//            map.add(head);
//            temp = temp.nextOne(temp.head);
//            if (map.contains(temp)) return true;
//        }
        return false;
    }
}
