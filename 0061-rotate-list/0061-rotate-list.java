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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int length = countNodes(head);  
        k = k % length; 
        if(k == 0) return head;
        
        ListNode curr = head;
        int steps = length - k;
        
        // Using while loop as you prefer
        while(steps > 1) {  // Changed condition to prevent null
            curr = curr.next;
            steps--;
        }
        
        ListNode newHead = curr.next;
        curr.next = null;
        
        ListNode tail = newHead;
        // Added null check to prevent NPE
        while(tail != null && tail.next != null) {
            tail = tail.next;
        }
        
        if(tail != null) {
            tail.next = head;
        }
        
        return newHead;
    }
    
    public int countNodes(ListNode head) {
        ListNode fast = head;
        int count = 0;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            count += 2;
        }
        
        if(fast != null) {
            count++;
        }
        
        return count;
    }
}