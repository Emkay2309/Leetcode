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
    public int rob(TreeNode root) {
        int [] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        if(root.left == null && root.right == null) {
            return new int [] {0,root.val};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // If we rob this node, we cannot rob children , so use 0th index
        int rob = root.val + left[0] + right[0];

        // If we don't rob this node, we can rob or not rob children 
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}
