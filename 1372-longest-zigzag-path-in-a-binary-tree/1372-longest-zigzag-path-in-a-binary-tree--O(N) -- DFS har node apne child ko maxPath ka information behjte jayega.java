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
    public int maxPath;
    public int longestZigZag(TreeNode root) {
        maxPath = 0;
        dfs(root , 0 , true);
        dfs(root , 0 , false);
        return maxPath;
    }

    public void dfs(TreeNode root , int steps , boolean goLeft) {
        if(root == null) return;

        maxPath = Math.max(maxPath , steps);

        if(goLeft == true) {
            dfs(root.left , steps+1 , false);
            dfs(root.right , 1 , true);
        }
        else {
            dfs(root.right , steps+1 , true);
            dfs(root.left , 1 , false);
        }
    }
}