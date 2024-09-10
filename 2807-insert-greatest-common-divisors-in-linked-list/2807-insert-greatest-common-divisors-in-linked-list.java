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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null ) return head;

        ListNode val = helper(head);
        ListNode ans = head;
        
        ans.next = null;
        ans.next = val;

        return ans;
    }
    public ListNode helper(ListNode head) {
        if(head == null || head.next == null ) return head;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode ans ;
        
        ans = helper(head.next);
        int val = gcd(curr.val , next.val);

        ListNode newNode = new ListNode(val);

        curr.next = newNode;
        newNode.next = next;
        return newNode;
    }
    public int gcd(int a , int b ) {
        if(b==0) return a;

        return gcd(b , a%b);
    }
}