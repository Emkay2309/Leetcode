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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode (-1);
        dummy.next = head;

        ListNode curr = head;
        int pfSum = 0;
        Map<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);

        while( curr != null) {
            int val = curr.val;
            pfSum += val;

            if(map.containsKey(pfSum)) {
                // delete
                int currSum = pfSum;
                ListNode start = map.get(pfSum);
                ListNode temp = start;

                while(temp != curr) {
                    temp = temp.next;
                    currSum += temp.val;

                    if(temp != curr) 
                        map.remove(currSum);
                }
                // make conenction
                start.next = curr.next;
            }
            else {
                map.put(pfSum , curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}