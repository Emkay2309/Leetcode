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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null && subRoot != null) return false;
        if(root != null && subRoot == null) return false;

        if(root.val == subRoot.val) {
            if(dfs(root , subRoot)) {
                return true;
            }
        } 
        
        boolean left = isSubtree(root.left , subRoot);
        boolean right = isSubtree(root.right , subRoot);

        return left || right;
    }

    public boolean dfs(TreeNode root , TreeNode r1) {
        if(root == null && r1 == null) return true;
        if(root == null || r1 == null || root.val != r1.val) return false;

        return dfs(root.left , r1.left) && dfs(root.right , r1.right);
    }
}