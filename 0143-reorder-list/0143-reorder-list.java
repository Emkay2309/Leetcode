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
    ListNode curr;
    public void reorderList(ListNode head) {
        curr = head;
        solve(head);
    }
    public void solve(ListNode head) {
        if(head == null) return;
        solve(head.next);

        if(curr.next == null) {
            return;
        }
        else if(curr == head) {
            head.next = null;
            return;
        }

        ListNode temp = curr.next;
        curr.next = head;
        head.next = (head == temp) ? null : temp;

        curr = temp;
    }
}