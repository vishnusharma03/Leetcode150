package src;

import java.math.BigInteger;
import java.util.List;

public class Leetcode2 {
    public static void main(String[] args) {

    }

    //  Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode svAns = new ListNode(0);

        ListNode temp = svAns;

        helperAddition(temp, l1, l2, 0);

        return svAns.next;
    }

    private void helperAddition(ListNode temp, ListNode l1, ListNode l2, int carry) {
        if (l1 != null && l2 != null){

            int one = l1.val + l2.val + carry;
            temp.next = new ListNode(one%10);
            temp = temp.next;
            carry = one/10;
            l1 = l1.next;
            l2 = l2.next;
            helperAddition(temp, l1, l2, carry);
        }
        else if (l1==null & l2!=null){
            helperAddCarry(temp, l2, carry);
        }
        else if (l1 != null){
            helperAddCarry(temp, l1, carry);
        }else if (carry>0){
            temp.next = new ListNode(carry);
        }
    }

    private void helperAddCarry(ListNode temp, ListNode list, int carry) {
        if (list!=null) {
            int one = list.val + carry;
            temp.next = new ListNode(one%10);
            temp = temp.next;
            carry = one/10;
            list = list.next;
            helperAddCarry(temp, list, carry);
        }else if (carry>0){
            temp.next = new ListNode(carry);
        }
    }
}


//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long num1 = helperNum(l1, 0);
//        long num2 = helperNum(l2, 0);
//        long ans = num1 + num2;
//        System.out.println(ans);
//        if (ans==0) return new ListNode(0);
//        ListNode ansList = new ListNode();
//        ListNode temp = ansList;
//
////        while(ans>0){
////            int var = (int)(ans%10);
////            ListNode one = new ListNode(var);
////            if (temp==null)
////                temp = one;
////            else{
////                temp.next = one;
////                temp = temp.next;
////                ans = ans/10;
////            }
////        }
//        buildList(temp, ans);
//        return ansList;
//    }
//
//    public long helperNum(ListNode list, int i){
//        long ansOne = 0;
//        if (list == null)
//            return ansOne;
//
//        ansOne += list.val*ex(i);
//        return ansOne + helperNum(list.next, i+1);
//    }
//    public long ex(int i){
//        if(i==0)
//            return 1;
//        return 10 * ex(i-1);
//    }
//    public void buildList(ListNode ans, long num){
//        if (num==0){
//            return;
//        }
//
//        BigInteger one = num.shiftRight(1);
//        System.out.println(1);
//        ListNode sv = new ListNode(one.intValue());
//        if (ans == null){
//            ans = sv;
//        }
//        else {
//            ans.next = sv;
//            ans = ans.next;
//        }
//        buildList(ans, num);
////        return ans;
//    }
//}
