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
        
        // Initialize a global variable "prev" as null to keep track of the previous node in the flattened tree
    public TreeNode prev = null;

    // A method to flatten the given binary tree into a singly linked list in-place
    public void flatten(TreeNode root) {
        // If the root node is null, return
        if(root == null){
            return;
        }

        // Recursively flatten the right subtree first
        flatten(root.right);
        // Recursively flatten the left subtree second
        flatten(root.left);

        // Set the right child of the current node to the previous node in the flattened tree
        root.right = prev;
        // Set the left child of the current node to null
        root.left = null;
        // Update the previous node to be the current node
        prev = root;
    }
        
}