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
        ListNode firstNode = null, secondNode = null;
        ListNode curr = head;
        int length = 0;
        
        // Find length and the k-th node from start
        while (curr != null) {
            length++;
            if (length == k) {
                firstNode = curr;
            }
            curr = curr.next;
        }
        
        // Find the k-th node from end (length-k+1 from start)
        curr = head;
        for (int i = 1; i <= length - k; i++) {
            curr = curr.next;
        }
        secondNode = curr;
        
        // Swap values
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        
        return head;
    }
}