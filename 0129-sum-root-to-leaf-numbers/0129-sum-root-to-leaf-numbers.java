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
    public int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root , 0);
        return ans;
    }

    public void dfs(TreeNode root , int curr) {
        if(root == null) return;

        curr = (curr*10)+root.val;
        
        if(root.left == null && root.right == null) {
            ans += curr;
            return;
        }

        dfs(root.left , curr);
        dfs(root.right , curr);
    }
}