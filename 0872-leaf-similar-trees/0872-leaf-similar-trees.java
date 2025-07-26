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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        StringBuilder s1 = new StringBuilder();
        dfs(root1, s1);

        StringBuilder s2 = new StringBuilder();
        dfs(root2, s2);

        return s1.toString().equals(s2.toString());
    }

    public void dfs(TreeNode root , StringBuilder sb) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            sb.append(root.val).append(",");
        }
        dfs(root.left , sb);
        dfs(root.right , sb);
    } 
}