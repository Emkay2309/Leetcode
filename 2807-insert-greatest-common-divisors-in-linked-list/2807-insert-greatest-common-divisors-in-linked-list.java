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
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {

            ListNode next = curr.next;

            int value = gcd(curr.val , next.val);
            ListNode newNode = new ListNode(value);

            curr.next = newNode;
            newNode.next = next;

            curr = next;
            next = next.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;  // Base case: GCD(a, 0) = a
        }
        return gcd(b, a % b);  // Recursive step: GCD(a, b) = GCD(b, a % b)
    }
}