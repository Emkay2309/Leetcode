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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int ans = 0;

        Stack <ListNode> st = new Stack();
        
        while(curr != null) {
            st.add(curr);
            curr = curr.next;
        }
        curr = head;

        int n = st.size();
        int len = n/2;

        while(len > 0) {
            ListNode pop = st.pop();

            int sum = pop.val + curr.val;
            ans = Math.max(ans , sum);

            curr = curr.next;
            len--;
        }
        return ans;
    }
}