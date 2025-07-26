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
    private long max = 0;
    private long total = 0;
    private final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        max = -1;
        total = sum(root);
        dfs(root);
        return (int)(max%MOD); 
    }

    public int dfs(TreeNode root ) {
        if(root == null) return 0;

        int left  = dfs(root.left );
        int right = dfs(root.right );
        int subTree = root.val + left + right;

        max = Math.max( max , subTree * (total-subTree));
        return subTree;
    }

    public int sum(TreeNode root) {
        if(root == null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
}