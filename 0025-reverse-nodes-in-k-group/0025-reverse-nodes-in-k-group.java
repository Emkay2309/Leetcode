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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        while(curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if(count == k) { // reverse k nodes
            ListNode reversedList = reverse(head , k);
            // connected with rest 
            head.next = reverseKGroup(curr , k);
            return reversedList;
        }
        return head;
    }

    public ListNode reverse(ListNode head , int k) {
        if(k == 1 || head.next == null) return head;

        ListNode last = reverse(head.next , k-1);
        head.next.next = head;
        head.next = null;
        return last;
    }
     
}