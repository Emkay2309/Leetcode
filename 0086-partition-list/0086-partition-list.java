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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode smallerHead = smaller;

        ListNode larger = new ListNode(-1);
        ListNode largerHead = larger;

        ListNode curr = head;

        while(curr != null) {

            if(curr.val < x) {  
                smallerHead.next = curr;
                smallerHead = smallerHead.next;  

            }
            else {
                largerHead.next = curr;
                largerHead = largerHead.next;

            }
            curr = curr.next;
        }
        
        smallerHead.next = larger.next;
        largerHead.next = null;

        return smaller.next;


    }
}