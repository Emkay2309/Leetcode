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
        int n = lists.length;
        if(n==0 ) return null;
        if(n == 1) return lists[0];

        return partMerge(0, n-1 , lists);
    }

    public ListNode partMerge(int start , int end , ListNode [] list) {
        if(start == end) return list[start];

        if(start == end-1) return merge(list[start] , list[end]);

        int mid = start + (end-start)/2;

        ListNode leftList =  partMerge(start , mid , list);
        ListNode rightList = partMerge(mid+1 , end , list);

        return merge(leftList , rightList);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val) {
            l1.next = merge(l1.next , l2);
            return l1;
        }
        else {
            l2.next = merge(l1 , l2.next);
            return l2;
        }

    }
}