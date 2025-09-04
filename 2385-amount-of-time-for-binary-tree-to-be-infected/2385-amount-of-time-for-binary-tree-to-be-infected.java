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
    int ans;
    public int amountOfTime(TreeNode root, int start) {
        ans = 0;
        dfs(root , start);
        return ans;
    }

    public int dfs(TreeNode root , int k) {
        if(root == null) return 0;

        int left = dfs(root.left, k);
        int right = dfs(root.right , k);

        if(root.val == k) {
            ans = Math.max(left,right);
            return -1;
        }
        else if(left >= 0  &&  right >=0) {
            return 1 + Math.max(left,right);
        }
        else {
            int dist = Math.abs(left) + Math.abs(right);
            ans = Math.max(ans , dist);
            return Math.min(left , right) - 1;
        }
    }
}