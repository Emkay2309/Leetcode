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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        int pfSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0,dummy);

        while(curr != null) {
            pfSum += curr.val;

            if(map.containsKey(pfSum)) {
                //delete

                ListNode start = map.get(pfSum);
                ListNode temp = start;

                int pSum = pfSum;

                while(temp != curr) {
                    temp = temp.next;
                    pSum += temp.val;

                    if(temp != curr) {
                        map.remove(pSum);
                    }
                }
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