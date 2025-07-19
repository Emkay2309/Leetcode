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
        if(head == null) return null;

        ListNode reversed = reverse(head);
        ListNode added = add(reversed, reversed);
        return reverse(added);
    }

    public ListNode add(ListNode l1 , ListNode l2)  {
        ListNode ansHead = new ListNode(-1);
        ListNode ans = ansHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry>0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;

            int add = sum%10;
            carry = sum/10;

            ListNode newNode = new ListNode(add);

            ans.next = newNode;
            ans = ans.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return ansHead.next;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}