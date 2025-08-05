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
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;

        Counter count = new Counter();
        int currSum = sum(root , count);
        if(currSum/count.count == root.val) {
            ans++;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public int sum(TreeNode root , Counter count ) {
        if(root == null) return 0;
        count.count++;
        return sum(root.left , count) + sum(root.right , count) + root.val;
    } 
}

class Counter {
    int count = 0;
}