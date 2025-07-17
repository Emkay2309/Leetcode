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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return null;

        ListNode curr = head;
        int pfSum = 0;
        
        while(curr != null) {
            pfSum += curr.val;

            if(pfSum == 0) {
                return removeZeroSumSublists(curr.next);
            }
            curr = curr.next;
        }

        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}