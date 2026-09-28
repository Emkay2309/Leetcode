class Solution {
    int ans = 0;

    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int max = Math.max(root.val, Math.max(left, right));

        if (root.val == max) {
            ans++;
        }

        return max;
    }
}