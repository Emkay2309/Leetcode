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
        //Keep 2 pointers to iterate on the list
        ListNode slow = head;
        ListNode fast = head;

        //set first pointer just before the first pointer
        while( --k > 0) {
            fast = fast.next;
        }

        //assign node to the first required point
        ListNode first = fast;

        //now iterate fast till the last
        //at this point slow will be exactly k steps before
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        //assign node to the first required point
        ListNode second = slow;

        //swap the values of bioth the pointers
        int temp = second.val;
        second.val = first.val;
        first.val = temp;


        //return head
        return head;
    }
}