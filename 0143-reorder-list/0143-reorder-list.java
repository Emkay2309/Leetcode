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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;
        ListNode curr = head;

        while( rev != null) {
            ListNode tempCurr = curr.next;
            curr.next = rev;

            ListNode temprev = rev.next;
            rev.next = tempCurr;

            curr = tempCurr;
            rev = temprev;
        }
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = reverse(head.next);
        head.next.next = head;
        head.next  = null;

        return curr;
    }

}