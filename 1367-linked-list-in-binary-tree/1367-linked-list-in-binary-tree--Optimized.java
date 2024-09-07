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

        //check if the current root has the exact linkedlist
        //if not check for left and right children
        boolean checkSame = check(head , root) ;
        //if(checkSame) return true;

        //check for children --- do they have the Linked List
        boolean left = isSubPath(head , root.left);
        boolean right = isSubPath(head , root.right);

        //if any of them has required LinkedList , so use or 
        return checkSame || left || right;
    }

    public boolean check(ListNode head , TreeNode root) {
        //if the head reached null means it traversed the complete linkedlist
        if(head == null) return true;

        //if the root completly traversed , then no LL found so false
        if(root == null) return false;

        //check the values at both root and head same or not
        if(head.val != root.val) return false;

        //call the next and left right child for iterating
        boolean left =  check(head.next , root.left);
        boolean right = check(head.next , root.right);

        
        return left || right;
    }
}