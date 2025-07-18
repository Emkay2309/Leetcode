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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);

        if(n == len ) return head.next;

        int travel = len-n;
        ListNode curr = head;

        while(travel-- > 1) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
    public int getLength(ListNode head) {
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
}