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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) {
            return ans;
        }

        dfs(root , ans);
        return ans;
    }

    public void dfs(TreeNode root , List<Integer> ans) {
        if(root == null) return;

        dfs(root.left , ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
}