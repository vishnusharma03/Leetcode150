package src;

import java.lang.Math;
import java.util.HashSet;

public class Leetcode141 {

     // Definition for singly-linked list.
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
             val = x;
             next = null;
          }
      }


    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if (s==f)
                return true;
        }
        return false;
    }
}
