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
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        int [] freq = new int [10];
        dfs(root , freq);
        return ans;
    }

    public void dfs(TreeNode root , int [] freq) {
        if(root == null) return;

        freq[root.val]++;

        if(root.left == null && root.right == null) {
            int odd = 0;
            int even = 0;

            for(int val : freq) {
                if(val % 2 == 0) even++;
                else odd++;
            }
            if(odd <= 1) ans++;
        }

        dfs(root.left , freq);
        dfs(root.right , freq);

        freq[root.val]--;
    }
}