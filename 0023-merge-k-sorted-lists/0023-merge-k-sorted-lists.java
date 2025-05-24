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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0  )  {
            return null;
        }
        return mergeSort(lists , 0 , lists.length-1 );
    }
    public ListNode mergeSort(ListNode [] lists , int start , int end)  {
        if( start == end) {
            return lists[start];
        }
        int mid = (start + end)/2;

        ListNode left =  mergeSort(lists , start , mid);
        ListNode right =  mergeSort(lists , mid+1 , end);

        return merge(left,right);
    }
    public ListNode  merge(ListNode l1 , ListNode l2)  {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while( l1 != null  &&   l2 != null) {
            if(l1.val <= l2.val) {
                ans.next = l1;
                l1 = l1.next;
            }
            else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null) {
            ans.next = l1;
        }
        if(l2 != null) {
            ans.next = l2;
        }
        return dummy.next;
    }
}