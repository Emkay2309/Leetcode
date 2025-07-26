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
    public int max;
    public int maxAncestorDiff(TreeNode root) {
        max = -1;
        maxDiff(root);
        return max;
    }

    public void maxDiff(TreeNode root) {
        if(root == null) return;

        dfs(root , root.left);
        dfs(root , root.right);

        maxDiff(root.left);
        maxDiff(root.right);
    }

    public void dfs(TreeNode root , TreeNode child) {
        if(root == null || child == null) return;

        max = Math.max(max , Math.abs(root.val-child.val));

        dfs(root,child.left);
        dfs(root,child.right);
    }
}