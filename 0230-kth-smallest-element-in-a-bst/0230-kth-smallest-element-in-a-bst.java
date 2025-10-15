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
    public int kthSmallest(TreeNode root, int k) {
        int [] check = {k};
        if(root == null) return -1;

        return dfs(root , check).val;
    }
    public TreeNode dfs(TreeNode root , int [] k) {
        if(root == null) {
            return null;
        }
        TreeNode left = dfs(root.left , k);
        if(left != null) {
            return left;
        }
        k[0]--;
        if(k[0] == 0) {
            return root;
        }
        return dfs(root.right , k);
    }
}