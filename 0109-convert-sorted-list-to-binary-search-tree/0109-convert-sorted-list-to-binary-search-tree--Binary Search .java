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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        return createTree( 0 , list.size()-1 , list);
    }

    public TreeNode createTree(int start , int end , List<Integer> list) {
        if(start > end) {
            return null;
        }

        int mid = (start+end)/2;
        int val = list.get(mid);

        TreeNode root = new TreeNode(val);
        root.left = createTree(start , mid-1 , list);
        root.right = createTree(mid+1 , end , list);

        return root;
    }
}