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
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max( 0 , dfs(root.left));
        int right = Math.max(0 , dfs(root.right));
        int curr = root.val + left + right;

        max = Math.max(max , curr); 
        return root.val;
    }
}