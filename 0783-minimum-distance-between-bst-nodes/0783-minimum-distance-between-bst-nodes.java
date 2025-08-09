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
    public int min = Integer.MAX_VALUE;
    public Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        if(prev != null) {
            min = Math.min(min , root.val-prev);
        }
        prev = root.val;
        dfs(root.right);
    } 
}