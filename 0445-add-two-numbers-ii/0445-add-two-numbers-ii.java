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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s1 = reverse(l1);
        ListNode s2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int carry = 0;


        while(s1 != null || s2 != null || carry > 0) {
            int val1 = (s1 != null) ? s1.val : 0;
            int val2 = (s2 != null) ? s2.val : 0;

            int sum = val1 + val2 + carry;
            int add = sum%10;
            carry   = sum/10;

            ListNode currNode = new ListNode(add);
            ans.next = currNode;
            ans = ans.next;

            

            if(s1 != null) 
                s1 = s1.next;

            if(s2 != null) 
                s2 = s2.next;

        }
        ListNode ans1 = reverse(dummy.next);
        return ans1;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head , prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}