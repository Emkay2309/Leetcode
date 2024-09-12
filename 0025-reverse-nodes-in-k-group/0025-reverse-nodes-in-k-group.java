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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy, currNode = dummy, nextNode = dummy;
        int count = 0;

        while(currNode.next != null){
            count++;
            currNode = currNode.next;
        }

        while(count >= k){
            currNode = prevNode.next;
            nextNode = currNode.next;
            
            for(int i=1; i < k; i++){
                currNode.next = nextNode.next;
                nextNode.next = prevNode.next;
                
                prevNode.next = nextNode;
                nextNode = currNode.next;
                
            }
            prevNode = currNode;
            count -= k;
        }
        return dummy.next;
    }
}