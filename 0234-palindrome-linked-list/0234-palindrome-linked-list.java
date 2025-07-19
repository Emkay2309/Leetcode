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
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) return true;

        if(head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode mid = findMid(head);
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        ListNode l1 = head;

        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) return false;

            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }
}