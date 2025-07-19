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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head , curr = head.next;
        int i=1 , firstCritiPoint = 0 , prevCritiPoint = 0 , minDistance = Integer.MAX_VALUE;

        while(curr != null && curr.next != null) {

            if( (curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val) )  {
                if(prevCritiPoint == 0) {
                    firstCritiPoint = i;
                }
                else {
                    minDistance = Math.min(minDistance , i-prevCritiPoint);
                }
                prevCritiPoint = i;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        if(minDistance == Integer.MAX_VALUE) {
            return new int [] {-1,-1};
        }

        int maxDistance = prevCritiPoint - firstCritiPoint;
        return new int [] {minDistance , maxDistance};
    }
}