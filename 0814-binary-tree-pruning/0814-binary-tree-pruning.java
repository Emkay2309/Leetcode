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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)  return null;

        if(!is1Present(root.left)) {
            root.left = null;
        }
        if(!is1Present(root.right)) {
            root.right = null;
        }
        pruneTree(root.left);
        pruneTree(root.right);

        if(root.val == 0 && root.left==null && root.right==null) {
            return null;
        }
        return root;
    }

    public boolean is1Present(TreeNode root) {
        if(root == null) return false;

        if(root.val == 1) return true;

        boolean left = is1Present(root.left);
        boolean right = is1Present(root.right);

        return left || right;
    }
}