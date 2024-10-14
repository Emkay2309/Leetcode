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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null ||  head.next.next == null ) {
            return head;
        }

        ListNode oddHead = head;            // 1 -> 3 -> 5
        ListNode evenHead = head.next;      // 2 -> 4 -> null
        ListNode nextHead = head.next;      // 2 

        while(evenHead != null && evenHead.next != null) {
            oddHead.next = evenHead.next;
            oddHead = oddHead.next;
            evenHead.next = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = nextHead;
        return head;
    }
}