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
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> st = new Stack();

        while( curr != null) {
            st.add(curr);
            curr = curr.next;
        }

        curr = st.pop();
        int max = curr.val;

        ListNode ans = new ListNode(max);

        while(!st.isEmpty()) {
            ListNode popped = st.pop();
            if(popped.val >= max) {
                max = popped.val;
                ListNode newNode = popped;
                newNode.next = ans;

                ans = newNode;
            }
        }
        return ans;
    }
}