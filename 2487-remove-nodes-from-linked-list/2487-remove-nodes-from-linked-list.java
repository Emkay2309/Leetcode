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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int max = -1;
        ListNode prev = null;
        ListNode curr = head;

        while( curr != null) {
            max = Math.max( max , curr.val);

            if(curr.val < max) {
                ListNode next = curr.next;
                prev.next = next;
            }
            else {
                prev = curr;
            }
            curr = curr.next;
        }
        return reverse(head);

    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}