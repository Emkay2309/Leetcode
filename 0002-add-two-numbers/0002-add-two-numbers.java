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
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;

        int carry = 0;
        
        while(l1 != null  ||  l2 != null  ||  carry > 0)  {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int currSum = val1 + val2 + carry;
            carry = currSum / 10;
            int add = currSum % 10;

            ListNode newNode = new ListNode(add);
            curr.next = newNode;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }

            curr = curr.next;
        }

        return ans.next;
    }
}