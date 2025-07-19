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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;

        boolean check = checkList(head , root);

        boolean left = isSubPath(head , root.left);
        boolean right = isSubPath(head , root.right);

        return left || right || check;
    }

    public boolean checkList(ListNode head , TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if(head.val != root.val) return false;

        boolean left = checkList(head.next , root.left);
        boolean right = checkList(head.next , root.right);

        return left||right;
    }
}