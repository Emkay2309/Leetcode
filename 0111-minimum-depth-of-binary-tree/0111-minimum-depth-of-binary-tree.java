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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root , 1);
    }

    public int dfs(TreeNode root , int level) {
        if(root.left==null && root.right==null) return level;

        if(root.left == null) {
            return dfs(root.right,level+1);
        }
        if(root.right == null) {
            return dfs(root.left , level+1);
        }
        int left = dfs(root.left,level+1);
        int right = dfs(root.right,level+1);

        return Math.min(left,right);
    }
}