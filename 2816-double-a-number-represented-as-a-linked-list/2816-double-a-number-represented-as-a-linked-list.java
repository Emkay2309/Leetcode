/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        int lastCarry = doubleUtil(head);

        if(lastCarry > 0) {
            ListNode carryNode = new ListNode(lastCarry);
            carryNode.next = head;
            return carryNode;
        }
        return head;
    }

    public int doubleUtil(ListNode head)  {
        if(head == null) return 0;

        int carry = doubleUtil(head.next);
        int value = (head.val * 2) + carry;
        head.val = value%10;

        return value/10;
    }
}