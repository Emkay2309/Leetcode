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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        ListNode[] ans = new ListNode[k];
        curr = head;
        int eachBucketNodes = len / k;
        int extraNodes = len % k;

        for (int i = 0; i < k ; i++) {
            ans[i] = curr;
            for (int count = 1; count < eachBucketNodes + (extraNodes > 0 ? 1 : 0); count++) {
                curr = curr.next;
            }
            extraNodes--;
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }
        return ans;
    }
}