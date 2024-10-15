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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode dummy = head;
        ListNode ans = dummy;
        int count = 0;
        while(dummy != null) {
            dummy = dummy.next;
            count++;
        }

        int k1 = k;
        int k2 = count - k + 1;

        ListNode a = head;
        while(k1-- > 1 && a != null) {
            a = a.next;
        }

        ListNode b = head;
        while(k2-- > 1 && b != null) {
            b = b.next;
        }

        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        return ans;
    }
}