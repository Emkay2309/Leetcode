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

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val == 0 && root.left==null && root.right==null) {
            return null;
        }
        return root;
    }

    public boolean is1Present(TreeNode root) {
        if(root == null) return true;

        if(root.val == 1) return true;
        if(root.val == 0 ) return false;

        boolean left = is1Present(root.left);
        boolean right = is1Present(root.right);

        return left && right;
    }
}