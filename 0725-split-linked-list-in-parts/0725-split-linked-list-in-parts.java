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
    //  TC : O(N+N) = O(2N) = O(N)
    //  SC : O(N)
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = count(head);
        int each = n/k;
        int extra = n%k;

        ListNode [] ans = new ListNode [k];
        int u = 0;
        ListNode curr = head;
        ListNode prev = null;

        for(int i=0 ; i<k ; i++) {

            ans[u++] = curr;

            for(int j=1 ; j <= each+(extra>0 ? 1 : 0) ; j++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            extra--;
        }
        return ans;
    }

    public int count (ListNode head) {
        int ans = 0;
        while(head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }
}